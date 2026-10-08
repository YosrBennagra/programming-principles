# Law of Demeter & Tell, Don't Ask

## Wall Note / A4

- **Law of Demeter (LoD):** avoid making a caller depend on the internal object graph of its collaborators.
- **Tell, Don't Ask:** when an object owns a business invariant, ask it to enforce the rule instead of pulling its data into unrelated callers.
- Both are **heuristics**, not bans on dots, getters, queries or DTOs.

## Mechanism and example

Repeated navigation such as `order.getCustomer().getWallet().getBalance()` binds the caller to several relationships. An operation expressed at the appropriate owner reduces coupling.

~~~java
// External code knows and mutates the order's internal collection:
if (order.getItems().stream().anyMatch(Item::isRestricted)) {
    order.setReviewRequired(true);
}

// If Order truly owns the review invariant:
order.flagForReviewIfRequired();
~~~

This is only better when the rule really belongs to `Order`; do not move payment authorization, SQL or transport mapping into a domain entity just to avoid chained calls.

## Where these rules should NOT be applied mechanically

- Fluent builders, immutable values and read-only DTO projections are not automatically LoD violations.
- Reporting, serialization, UI rendering and pure calculations often legitimately query data.
- Integration DTOs and persistence records may deliberately be data carriers, not domain objects.
- Wrapping each getter with a forwarding method adds boilerplate and hides intent; it can violate KISS/YAGNI.
- Do not conceal timeouts, network calls, transaction boundaries or authorization effects behind friendly domain names.

## Senior exercise

Given `checkout.getOrder().getCustomer().getAccount().debit(amount)`:

1. Determine who owns authorization, debiting, consistency and remote failure behavior.
2. Compare an aggregate command, application use case and infrastructure gateway.
3. Identify the option that keeps invariants close to their owner without making `Order` a god object.
4. Write behavior-focused tests, including a negative authorization case and an ambiguous external failure.

## Connections

[Encapsulation](02-encapsulation-information-hiding.md) · [Ownership & Invariants](../01-oop-composition/01-ownership-invariants.md) · [Cohesion & Coupling](../05-cohesion-coupling/README.md) · [Separation of Concerns](../04-separation-of-concerns/README.md) · [KISS & YAGNI](../03-simplicity/README.md).
