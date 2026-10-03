# 10 — Error Handling

## Wall Note / A4

Classify failures:

```text
programmer bug
validation/domain rejection
expected operational failure
transient dependency failure
permanent dependency failure
system/resource failure
```

**Key rule:** errors are part of the contract; preserve context and handle them at the right boundary.

## Detailed Notes

### Exceptions versus result values

Exceptions work well for non-local exceptional control flow in languages designed around them. Result/option types make expected outcomes explicit.

The important decision is whether a failure is **expected business flow** or **exceptional/operational failure**.

### Preserve context

Wrap lower-level failures only when adding meaningful context, and preserve the original cause.

Bad:

```text
throw new RuntimeException("error")
```

Better:

```text
throw new OrderPersistenceException(orderId, cause)
```

### Boundary translation

A database exception should not necessarily leak to an HTTP client. Translate failures at boundaries:
- domain rejection → meaningful application result;
- missing resource → appropriate API status;
- infrastructure failure → internal error plus observability;
- transient dependency failure → retry only when safe.

### Logging

Do not log the same exception at every layer. Usually log where you have enough context and know the failure will not be handled further.

Avoid leaking credentials, tokens, personal data, or sensitive payloads.

### Recovery

Recovery includes retries, fallback, cancellation, compensation, circuit breaking, and graceful degradation. Recovery logic must match operation semantics.

### Common mistakes

- swallowing exceptions;
- catch-all blocks that continue in invalid state;
- exceptions for normal validation;
- losing the original cause;
- duplicate logging;
- returning null for unrelated failure types;
- retrying every exception.

### Senior-level understanding

Error handling is architecture. Define failure contracts, observability, recovery, and user-visible behavior as part of the happy-path design.

## Questions / Exercises

1. Expected domain failure versus exception?
2. When should an exception be translated?
3. Why is duplicate logging harmful?
4. What information must be preserved when wrapping?
5. Exercise: build an error taxonomy for one API endpoint.
6. Exercise: remove one broad catch block and replace it with intentional handling.

## Deep dives

- [Error Taxonomy & Contracts](01-error-taxonomy.md)
- [Boundary Translation, Retries & Recovery](02-boundaries-retries.md)
- [Error Logging & Observability](03-logging-observability.md)

## Connections

**Related:** [Defensive Programming](../12-defensive-programming/README.md), [Software Architecture](https://github.com/YosrBennagra/software-architecture) for resilience patterns.
