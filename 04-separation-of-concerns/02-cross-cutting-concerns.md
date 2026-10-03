# Cross-Cutting Concerns

## Wall Note / A4

Common cross-cutting concerns:
- authentication/authorization;
- transactions;
- logging/tracing;
- metrics;
- caching;
- validation;
- rate limiting.

**Key rule:** centralize repeated infrastructure policy without hiding important business behavior.

## Detailed Notes

### Why they are difficult

Cross-cutting concerns affect many features but are not the primary purpose of those features. Duplicating them creates inconsistency; hiding them too aggressively makes behavior invisible.

### Mechanisms

Depending on the stack, concerns can be handled using middleware, filters, interceptors, decorators, aspects, framework policies, or shared adapters.

The mechanism matters less than making scope and behavior predictable.

### Business versus technical validation

Transport validation such as malformed JSON belongs near the boundary. Domain rules such as "cannot cancel a shipped order" belong with domain policy.

### Transactions

Transaction boundaries should match consistency needs. An annotation everywhere is not a substitute for deciding which operations must be atomic.

### Observability

Logging and tracing can be centralized, but important domain events still need explicit semantic context.

### Common mistakes

- aspect-oriented logic that hides core behavior;
- duplicated authorization rules;
- transaction wrappers around remote calls;
- generic validation replacing domain invariants;
- logging every method automatically and creating noise.

## Questions / Exercises

1. Which concerns are cross-cutting in your application?
2. When should a concern stay explicit rather than hidden in middleware?
3. Exercise: separate transport validation from a domain invariant in one use case.

## Connections

**Parent:** [Separation of Concerns](README.md).

**Related:** [Error Logging & Observability](../10-error-handling/03-logging-observability.md), [Defensive Programming](../12-defensive-programming/README.md).
