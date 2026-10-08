# Checkout Refactoring Lab — SOLID, DRY, KISS, YAGNI

A small **runnable Spring Boot 4.1.1 + JDBC** exercise for changing code structure without changing behavior. Requires Java 21 and Maven 3.9+; the POM declares H2 and its JDBC test starter supplies JUnit Jupiter 6. This intentionally narrow example is **not** a production checkout reference architecture.

## Run

~~~bash
cd 16-senior-practice/labs/checkout-refactoring
mvn test
~~~

Maven downloads dependencies on first run. The dedicated `spring-boot-starter-jdbc-test` dependency provides Spring/JDBC testing support. This lab intentionally targets an actively supported Spring Boot generation. No HTTP server, broker, external database, or vendor SDK is needed. An in-memory H2 database is initialized from `schema.sql`.

## Scenario and invariants

`legacy/LegacyCheckout.java` mixes pricing, SQL and orchestration. The refactor extracts a **pure concrete** `PricingPolicy` and a **real infrastructure boundary** (`OrderWriter`). `CheckoutService` owns orchestration and the Spring transaction.

Preserve these observable requirements:

1. Positive quantities, nonnegative unit prices, valid customer IDs and at least one line.
2. Monetary values use integer cents and checked arithmetic. Subtotals below 10,000 cents have no discount; from 10,000 cents a 10% discount is applied using integer truncation.
3. Successful checkout creates **exactly one order and one ORDER_PLACED outbox record** in one local database transaction.
4. Failure must roll back local DB changes. The outbox row does **not** itself deliver a message.
5. Legacy and refactored paths return equal totals; generated order IDs naturally differ.
6. Do not add speculative providers, tax engines, or a strategy interface for the one existing pricing rule.

## Explore the code

- `legacy/LegacyCheckout.java` — baseline: pure calculation, SQL and orchestration in one class.
- `solution/PricingPolicy.java` — after: a concrete pure pricing policy.
- `solution/CheckoutService.java` — after: a cohesive use case with a public transactional method.
- `solution/OrderWriter.java` and `JdbcOrderWriter.java` — one narrow port and its JDBC adapter.
- `CheckoutRegressionTest.java` — before/after behavior tests, boundaries, input constraints, overflow and defensive copying.
- `TransactionBoundaryTest.java` — a failing writer inserts one row then throws; the proxied use-case transaction should roll it back.

## Your refactoring assignment

1. Read regression tests and predict their results before opening the solution.
2. Ignore `solution/`. Refactor the mixed responsibilities in `legacy/LegacyCheckout.java`, keeping its behavior.
3. Extract pricing **without** designing for nonexistent discount variants.
4. Introduce the smallest useful persistence boundary; preserve a single local transaction.
5. Compare your refactor with `solution/`, run `mvn test`, and identify what the tests still cannot prove.
6. Record the design decision: change drivers, invariants, accepted costs, rejected alternatives and redesign triggers.

## Why this shape?

| Pressure | Smallest justified choice | Tempting alternative to reject |
|---|---|---|
| Pricing changes independently of SQL | Concrete `PricingPolicy` | An interface for each helper |
| DB/outbox is an infrastructure boundary | Narrow `OrderWriter` | Generic CRUD repository and factory hierarchy |
| Baseline and refactor must be compared | Keep intentional duplicate policy in the lab | Shared utility that hides the extraction |
| Only one discount rule is required | Direct calculation | Strategy registry for imagined variants |
| Two DB inserts must succeed or fail together | `@Transactional` on the Spring-invoked use case | Simulated in-memory atomicity |
| Existing behavior must be preserved | Regression tests | Tests tightly coupled to the internal call graph |

**Limits of proof:** the rollback test injects a writer that throws after an actual SQL insert. It checks Spring transaction interception on the use case; it does not verify event delivery, exactly-once processing, retries, idempotency, or cross-service atomicity. Those require separate requirements and tests. The application intentionally has no event publisher or network call.

**Senior questions:** When would a second pricing strategy be justified? Why not give the application service a `JdbcTemplate`? What breaks with transactional self-invocation? Why is an outbox record not proof of delivery? When could duplicating a rule across bounded contexts be safer than sharing a library?

Related: [SRP](../../../02-solid/01-srp.md) · [DIP](../../../02-solid/05-dip.md) · [DRY](../../../03-simplicity/01-dry-knowledge-duplication.md) · [YAGNI](../../../03-simplicity/02-kiss-yagni-complexity-budget.md) · [Overloaded Service](../../01-large-service-refactor.md).
