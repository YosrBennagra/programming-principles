# Behavioral & Architectural Smells

## Wall Note / A4

Watch for:
- hidden temporal coupling;
- global mutable state;
- service locator;
- distributed monolith behavior;
- speculative generality;
- swallowed failures.

**Key rule:** a smell becomes serious when hidden behavior or coupling makes correctness depend on knowledge outside the local code.

## Detailed Notes

### Temporal coupling

If callers must invoke methods in an undocumented sequence, the API allows invalid states. Prefer types or workflows that make sequencing explicit.

### Global mutable state

Global mutation creates invisible dependencies between tests, requests, threads, and features. Ownership becomes unclear.

### Service locator

A global dependency registry hides a module's real collaborators. Constructor-visible dependencies are easier to understand and test.

### Distributed monolith

Services can be independently deployed in theory yet still require synchronized releases, shared schemas, chatty calls, or cascading availability. Distribution without independence increases operational cost.

### Speculative generality

Unused extension points and abstractions create complexity today for uncertain future flexibility.

### Common mistakes

- calling every singleton an anti-pattern;
- splitting a monolith into services without reducing coupling;
- hiding service locator behind helper methods;
- preserving unused abstractions because they might be useful later.

## Questions / Exercises

1. What makes temporal coupling hidden?
2. How can microservices still form a distributed monolith?
3. Exercise: identify one invisible dependency and make it explicit.

## Connections

**Parent:** [Code Smells & Anti-Patterns](README.md).

**Architecture depth:** [Software Architecture](https://github.com/YosrBennagra/software-architecture).
