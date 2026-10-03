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

## Connections

**Parent:** [Clean Code](README.md).

**Related:** [Refactoring](../11-refactoring/README.md).
