# Boundary Abstractions & Test Doubles

## Wall Note / A4

```text
abstract where:
external effect
volatile technology
ownership boundary
or meaningful variation exists
```

**Key rule:** abstraction should isolate a real boundary, not satisfy a rule that every class needs an interface.

## Detailed Notes

### Good abstraction targets

Common useful boundaries include:
- database access;
- payment or cloud vendors;
- clocks and randomness when determinism matters;
- message brokers;
- external HTTP services;
- filesystem access;
- business policy with several real variants.

### Fakes, stubs, and mocks

A fake has a working simplified implementation, such as an in-memory repository.

A stub returns prepared values.

A mock verifies interactions.

Use the least coupled test double that proves the behavior you care about.

### Contract tests

When multiple adapters implement the same boundary, shared contract tests can verify they honor the expected semantics.

### Over-mocking

If tests know every internal method call, harmless refactoring breaks them. Favor observable outcomes and boundary interactions that matter.

### Common mistakes

- interface for every class;
- mock chains reflecting implementation structure;
- fake implementations with semantics different from production;
- abstracting standard library types without a reason.

## Questions / Exercises

1. What makes a dependency a meaningful boundary?
2. Fake versus stub versus mock?
3. Exercise: replace a brittle interaction-heavy unit test with a fake at a stable boundary.

## Connections

**Parent:** [Dependency Inversion & Injection](README.md).

**Related:** [Maintainability](../13-maintainability/README.md), testing repositories from the master roadmap.
