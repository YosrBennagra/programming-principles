# 05 — Cohesion & Coupling

## Wall Note / A4

Aim for:

```text
HIGH cohesion inside a module
LOW + explicit coupling between modules
```

**Cohesion:** how strongly elements belong together.

**Coupling:** how much one element depends on another.

**Key rule:** optimize for changes that remain local.

## Detailed Notes

### Cohesion

A cohesive module has responsibilities that belong together around one concept, capability, or change reason.

Signs of weak cohesion:
- unrelated methods;
- many unrelated dependencies;
- generic “Utils” or “Manager” classes;
- fields used by disjoint subsets of methods.

### Coupling

Coupling can be:
- compile-time/type coupling;
- runtime/service coupling;
- data/schema coupling;
- temporal coupling (“call A before B”);
- shared-state coupling;
- deployment coupling.

Not all coupling is bad. Software must connect. The goal is to make necessary coupling deliberate and stable.

### Stable dependencies

Depending on a stable domain contract is usually cheaper than depending on a volatile framework detail or remote service protocol throughout the codebase.

### Information coupling

Two modules can be tightly coupled even without direct imports if both know the same fragile data shape or ordering convention.

### Temporal coupling

An API that only works if methods are called in a hidden sequence is hard to use safely. Prefer types/workflows that make valid sequencing explicit.

### Common mistakes

- measuring coupling only through imports;
- creating event buses to hide rather than remove coupling;
- splitting cohesive behavior into tiny classes;
- sharing database tables as an implicit integration contract;
- confusing “no direct dependency” with independence.

### Senior-level understanding

A good modular design makes the **cost of change proportional to the size of the change**, not the size of the system.

## Questions / Exercises

1. Define cohesion and coupling.
2. Give examples of temporal and data coupling.
3. Why is an event bus not automatically decoupled?
4. What makes a dependency stable?
5. Exercise: identify one highly coupled module and list all forms of coupling, not just imports.

## Deep dives

- [Cohesion & Change Drivers](01-cohesion-change-drivers.md)
- [Coupling, Stability & Dependency Cost](02-coupling-stability.md)

## Connections

**Prerequisite:** [Separation of Concerns](../04-separation-of-concerns/README.md).

**Related:** [Dependencies](../08-dependencies/README.md), [Maintainability](../13-maintainability/README.md).
