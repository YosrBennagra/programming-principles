# 13 — Maintainability

## Wall Note / A4

Maintainability = how safely and economically software can be understood, changed, tested, operated, and removed.

Drivers:
- clarity;
- modularity;
- tests;
- dependency discipline;
- observability;
- documentation of decisions;
- low change blast radius.

**Key rule:** optimize for lifecycle cost, not only initial delivery speed.

## Detailed Notes

### Changeability

Maintainable code localizes changes. A small requirement should not require understanding twenty unrelated modules.

Measure design quality partly by **change amplification**: how many places must change for one concept?

### Testability

Tests provide change confidence. Unit tests are valuable for isolated logic; integration tests validate boundaries; end-to-end tests validate critical workflows.

Do not optimize solely for test count. Tests should protect important behavior and contracts.

### Observability and operability

Software is maintained in production too. Useful logs, metrics, traces, health signals, configuration, graceful shutdown, and understandable failures are maintainability features.

### Documentation

Document:
- architecture decisions and rationale;
- non-obvious constraints;
- operational procedures;
- public contracts;
- setup and learning paths.

Do not duplicate what clear code already says.

### Dependency health

Every dependency adds upgrade, security, compatibility, operational, and conceptual cost. Prefer well-maintained dependencies that remove substantial work.

### Deletability

Good modularity makes features removable. Code that cannot be safely deleted is often strongly coupled or poorly understood.

### Common mistakes

- equating maintainability with clean formatting;
- excessive abstraction that increases navigation cost;
- tests tightly coupled to implementation;
- undocumented critical operational knowledge;
- dependencies added for tiny utility functions;
- refusing to delete obsolete code.

### Senior-level understanding

Maintainability is an economic property. Spend design effort where future change probability and failure impact justify it.

## Questions / Exercises

1. What is change amplification?
2. How does observability affect maintainability?
3. Why is deletability a useful design test?
4. When is a dependency worth its cost?
5. Exercise: estimate the blast radius of changing one business rule today.
6. Exercise: delete one obsolete path and simplify the surrounding design.

## Connections

**Related:** [Clean Code](../09-clean-code/README.md), [Refactoring](../11-refactoring/README.md), [Software Architecture](https://github.com/YosrBennagra/software-architecture).
