# DRY, Knowledge Duplication & Coupling

## Wall Note / A4

```text
same text ≠ same knowledge
same rule in multiple places = real DRY risk
```

**Key rule:** deduplicate knowledge that must change together; do not merge code only because it looks similar.

## Detailed Notes

### Knowledge duplication

Two blocks are a harmful duplication when they encode the same decision or rule and should change together.

Examples:
- the same tax rule in checkout and invoicing;
- the same authorization condition in API and background job;
- the same protocol constant copied across modules.

### Coincidental similarity

Two pieces of code can look similar while representing different business concepts. Extracting them into one shared abstraction can couple unrelated evolution.

### Duplication versus shared dependency

A shared library removes duplicated code but creates a new dependency and release relationship. That trade-off matters across services or teams.

### Rule of Three

A small amount of duplication can be tolerated until repeated examples reveal the real common concept. This avoids premature abstraction.

### Common mistakes

- extracting every repeated five lines;
- creating generic utility functions with unrelated flags;
- sharing domain logic across bounded areas that should evolve independently;
- refusing temporary duplication during a safe refactor.

## Questions / Exercises

1. What is the difference between textual and knowledge duplication?
2. When can duplication improve independence?
3. Exercise: find two similar code paths and decide whether they represent the same business rule.

## Connections

**Parent:** [DRY, KISS & YAGNI](README.md).

**Related:** [Coupling & Stability](../05-cohesion-coupling/02-coupling-stability.md), [Refactoring](../11-refactoring/README.md).
