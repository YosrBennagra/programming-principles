# Resource Bounds & Fail-Safe Behavior

## Wall Note / A4

```text
unbounded:
input + queue + retries + concurrency + time
→ eventual overload
```

**Key rule:** every resource-consuming operation needs a practical bound and a defined failure policy.

## Detailed Notes

### Bound the system

Important limits include:
- request body size;
- collection size;
- queue depth;
- concurrency;
- retry count;
- recursion depth;
- timeout or deadline;
- memory-heavy batch size;
- file upload size.

Bounds turn overload into a controlled outcome instead of process failure.

### Fail fast

Fail fast when an internal invariant is broken or continuing risks corrupt state.

Examples:
- impossible state transition;
- corrupted configuration;
- missing mandatory dependency.

### Graceful degradation

Degrade when a reduced service is still semantically correct.

Examples:
- return cached catalog data;
- disable a recommendation widget;
- queue non-critical analytics later.

Do not degrade by fabricating authoritative data.

### Backpressure and rejection

Rejecting work can be healthier than accepting work that cannot complete within a useful deadline. Backpressure preserves the rest of the system.

### Safe defaults

Defaults must be conservative in high-impact areas. Security permissions, money, and destructive operations should not silently "guess" permissive values.

### Common mistakes

- unbounded in-memory queues;
- retry forever loops;
- fail-open authorization;
- catching out-of-memory style failures and continuing normally;
- fallback data that violates business truth.

## Questions / Exercises

1. Why is a bounded queue safer than an unbounded queue?
2. Fail fast versus graceful degradation?
3. Exercise: define size, concurrency, retry, and timeout limits for a file-processing endpoint.

## Connections

**Parent:** [Defensive Programming](README.md).

**Related:** [Async & Backpressure](https://github.com/YosrBennagra/computer-science-fundamentals/blob/main/08-concurrency/03-async-backpressure.md), [Error Handling](../10-error-handling/README.md).
