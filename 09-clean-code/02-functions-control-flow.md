# Functions & Control Flow

## Wall Note / A4

```text
function:
one coherent purpose
one abstraction level
visible effects
clear happy path
```

**Key rule:** optimize for local reasoning, not arbitrary function length.

## Detailed Notes

### Cohesive functions

A function should tell one understandable story. It can contain several steps if those steps belong to the same abstraction level.

### Guard clauses

Early returns can remove nested conditionals and make invalid or exceptional cases explicit before the main path.

### Parameter pressure

Many parameters often indicate a missing concept, mixed responsibility, or excessive orchestration. Do not hide the problem by passing an untyped map.

### Command-query separation

Where practical, distinguish operations that return information from operations that change state. This reduces hidden side effects.

A **query** returns information without changing business-visible state; a **command** changes state. Prefer APIs whose intent is visible:

~~~java
long available = inventory.availableUnits(sku); // query
inventory.reserve(sku, count);                   // command
~~~

A command may still return an ID, receipt, or status. The strict "commands return nothing" version is a teaching heuristic, not an absolute rule. Metrics, caching and logging do not necessarily change business-visible state, but hidden domain mutations are dangerous. Queries may still fail, time out, or report eventually consistent data: their contract should not hide those properties.

Method-level command-query separation is **not CQRS** (the architectural separation of read and write models). A local design smell does not justify a CQRS architecture.

### Control flow

Prefer explicit branches when decisions matter. Clever chains and dense expressions can be harder to debug than a few clear statements.

### Common mistakes

- extracting every three lines into a method;
- nested condition pyramids;
- helper functions that conceal important state changes;
- giant parameter lists;
- compressed code that sacrifices debuggability.

## Questions / Exercises

1. What does "one abstraction level" mean?
2. When do guard clauses help?
3. Exercise: flatten a deeply nested validation workflow.
4. Exercise: find an operation that returns data while changing domain state; redesign its contract or defend the exception.

## Connections

**Parent:** [Clean Code](README.md).

**Related:** [Refactoring](../11-refactoring/README.md).
