# Error Taxonomy & Contracts

## Wall Note / A4

```text
domain rejection ≠ programmer bug ≠ dependency failure ≠ resource failure
```

**Key rule:** classify failures before deciding how to represent or recover from them.

## Detailed Notes

### Categories

Expected domain outcomes include invalid transitions, insufficient balance, or unavailable inventory. Programmer bugs include violated internal assumptions and null dereferences. Operational failures include timeouts, unavailable dependencies, disk errors, or exhausted resources.

These categories should not be handled identically.

### Contracts

An API should make expected failure modes understandable. Domain failures may be typed results or documented exceptions. Infrastructure failures should preserve diagnostic context without leaking implementation details across boundaries.

### Programmer bugs

Do not silently convert programming defects into ordinary business results. Failing fast can be safer than continuing with corrupted assumptions.

### Senior concerns

A useful error model answers: Can the caller correct it? Can it retry? Is the outcome ambiguous? Should it alert an operator? Does it indicate invalid internal state?

### Common mistakes

- one generic exception for everything;
- returning null for unrelated failures;
- catching bugs and continuing;
- exposing database or vendor exceptions directly to clients.

## Questions / Exercises

1. Domain rejection versus operational failure?
2. Which failures are retryable?
3. Exercise: build an error taxonomy for order creation.

## Connections

**Parent:** [Error Handling](README.md).

**Related:** [Defensive Programming](../12-defensive-programming/README.md).
