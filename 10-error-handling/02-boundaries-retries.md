# Boundary Translation, Retries & Recovery

## Wall Note / A4

```text
low-level failure
→ add context
→ translate at ownership boundary
→ retry only when semantics allow
```

**Key rule:** recovery belongs where enough context exists to know whether it is safe.

## Detailed Notes

### Translation

Infrastructure exceptions should usually be translated into application-level failures at the boundary that understands their meaning. Preserve the original cause for diagnostics.

### Retries

Retry transient failures only. A repeated write must be idempotent or protected by an idempotency mechanism.

Nested retries can multiply attempts unexpectedly. Assign retry ownership deliberately.

### Cancellation and deadlines

Recovery must respect caller cancellation and the remaining deadline. Retrying after the useful response window has expired wastes capacity.

### Fallbacks

A fallback is safe only when degraded behavior is semantically acceptable. Returning stale catalog data may be acceptable; fabricating an account balance is not.

### Common mistakes

- retrying every exception;
- retrying non-idempotent writes blindly;
- hiding failure with meaningless defaults;
- fallback paths that are rarely tested;
- losing the original cause during translation.

## Questions / Exercises

1. Where should a database timeout become an application failure?
2. Why are nested retries dangerous?
3. Exercise: design recovery rules for a read-only catalog request and for payment creation.

## Connections

**Parent:** [Error Handling](README.md).

**Related:** [Computer Science: Timeouts & Retries](https://github.com/YosrBennagra/computer-science-fundamentals/blob/main/04-networking/04-timeouts-retries.md).
