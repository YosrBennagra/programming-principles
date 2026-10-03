# 04 — Separation of Concerns

## Wall Note / A4

Separate code when concerns:
- change for different reasons;
- require different expertise;
- have different lifecycle/failure/security rules.

```text
business policy ≠ transport ≠ persistence ≠ presentation
```

**Key rule:** boundaries should isolate change, not just create folders.

## Detailed Notes

A concern is a coherent area of responsibility. Separation of concerns (SoC) keeps unrelated concerns from becoming entangled.

### Example

A controller that validates HTTP details, calculates pricing, opens transactions, runs SQL, formats email, and records metrics has several concerns mixed together.

A clearer flow might be:

```text
HTTP adapter
→ application use case
→ domain policy
→ repository / external ports
```

This does not require a complex architecture for every project. It means keep policy separate from delivery and infrastructure when those parts change independently.

### Horizontal versus vertical separation

Layered systems separate by technical role: UI, service, repository. Feature-oriented systems group a use case vertically while still separating internal concerns.

Both can work. The real test is whether a common change stays localized.

### Cross-cutting concerns

Logging, authorization, tracing, transactions, caching, and validation often affect many features. Handle them consistently through explicit infrastructure mechanisms rather than scattering logic everywhere.

### Over-separation

Too many micro-modules can fragment a simple workflow. Every boundary has cost: indirection, files, interfaces, dependency rules, and navigation.

### Common mistakes

- calling directory structure “separation” while responsibilities remain tangled;
- mixing business rules with framework APIs;
- placing all business logic in generic service classes;
- creating layers that only pass data through unchanged;
- splitting cohesive code only to satisfy a style guide.

### Senior-level understanding

The purpose of SoC is to make change safer. A boundary is valuable when it protects a different rate of change, owner, policy, technology, or failure model.

## Questions / Exercises

1. What makes two concerns genuinely different?
2. Why are layers not automatically good separation?
3. Name common cross-cutting concerns.
4. When does separation become overengineering?
5. Exercise: take one endpoint and label transport, application, domain, persistence, and cross-cutting concerns.

## Deep dives

- [Policy, Orchestration & Infrastructure Boundaries](01-policy-boundaries.md)
- [Cross-Cutting Concerns](02-cross-cutting-concerns.md)

## Connections

**Related:** [Cohesion & Coupling](../05-cohesion-coupling/README.md), [Software Architecture](https://github.com/YosrBennagra/software-architecture).
