# Case 3 — Design Error Boundaries

## Scenario

A REST endpoint places an order.

Possible outcomes include:
- malformed JSON;
- invalid quantity;
- product not found;
- insufficient inventory;
- database timeout;
- payment timeout with unknown outcome;
- programmer bug;
- downstream rate limit.

Current implementation catches Exception and returns HTTP 400 with the message.

## Why this is dangerous

It collapses failures with different:
- ownership;
- retry semantics;
- observability requirements;
- user meaning;
- security implications.

A database outage is not a client validation failure. A programmer bug should not be converted into normal domain flow.

## Layered error model

```text
transport parsing
→ application/domain outcomes
→ infrastructure failures
→ boundary translation to HTTP
```

Examples:
- malformed payload → 400;
- valid request rejected by business rule → explicit domain/application result;
- missing product → 404 or domain-specific equivalent;
- transient infrastructure failure → 5xx, telemetry, maybe safe retry;
- payment timeout → ambiguous state requiring idempotency/reconciliation;
- programmer bug → fail request, capture diagnostics, do not expose internals.

## Logging rule

Do not log the same exception at every layer.

Log where:
- the failure is no longer being propagated internally;
- enough context exists;
- sensitive data can be controlled.

## Exercise

Build a table for every scenario with:
- category;
- public response;
- retryability;
- whether outcome is known;
- logging level/context;
- operational alert need.

## Connections

[Error Taxonomy](../10-error-handling/01-error-taxonomy.md) · [Boundary Translation](../10-error-handling/02-boundaries-retries.md) · [Defensive Programming](../12-defensive-programming/README.md)
