# 12 — Defensive Programming

## Wall Note / A4

Trust boundaries, not everything.

```text
external input → validate
internal invariant → enforce
resource use → bound
failure → fail safely + observably
```

**Key rule:** make invalid states hard to represent and dangerous assumptions explicit.

## Detailed Notes

### Validate at boundaries

Validate data entering from users, files, networks, queues, databases with weak constraints, and third-party systems.

Once validated and converted into strong internal types, avoid repeating the same checks everywhere.

### Invariants

An invariant is a condition that must remain true. Enforce critical invariants close to the state they protect.

Examples:
- quantity > 0;
- end time ≥ start time;
- order cannot ship before payment;
- account balance updates remain atomic.

### Preconditions and postconditions

Preconditions describe valid inputs; postconditions describe guarantees after completion. Even without formal contract syntax, documenting and testing these expectations improves design.

### Resource bounds

Defensive systems bound:
- request size;
- queue size;
- retries;
- recursion/depth;
- concurrency;
- timeouts;
- memory-heavy operations.

Unbounded behavior becomes an availability risk.

### Fail fast versus graceful degradation

Fail fast when continuing would corrupt state or hide a programming error. Degrade gracefully when partial service is intentionally acceptable.

### Assertions

Assertions are useful for programmer assumptions that should always hold, not as a replacement for validating hostile/external input.

### Common mistakes

- validating everywhere and creating duplicated rules;
- accepting invalid state then trying to repair it later;
- swallowing impossible-state errors;
- unbounded queues/retries;
- trusting third-party payloads because they “should” be valid.

### Senior-level understanding

Defensive programming is about defining trust and ownership boundaries. Strong types and invariants reduce the amount of defensive checking needed.

## Questions / Exercises

1. Where should external validation occur?
2. Assertion versus validation?
3. Why are unbounded queues dangerous?
4. Fail fast versus graceful degradation?
5. Exercise: list all untrusted inputs for one service and define validation/bounds.

## Deep dives

- [Validation & Trust Boundaries](01-validation-trust-boundaries.md)
- [Resource Bounds & Fail-Safe Behavior](02-resource-bounds-failure.md)

## Connections

**Specialized continuation:** [Application Security](https://github.com/YosrBennagra/application-security) for security-specific trust-boundary and attack-surface depth.

**Related:** [Error Handling](../10-error-handling/README.md), [Immutability](../07-immutability/README.md).
