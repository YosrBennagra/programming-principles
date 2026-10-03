# Imperative & Declarative Programming

## Wall Note / A4

```text
imperative: describe HOW state changes
declarative: describe WHAT result or constraint is wanted
```

**Key rule:** use the style that makes the important intent easiest to see and verify.

## Detailed Notes

### Imperative style

Imperative code expresses a sequence of commands that change state.

It is effective when:
- execution order matters;
- an algorithm is naturally stepwise;
- explicit state transitions improve clarity;
- low-level control is useful.

### Declarative style

Declarative code states a desired result while another system determines execution details.

Examples include SQL queries, HTML structure, CSS rules, build descriptions, and many configuration systems.

The benefit is often reduced control-flow noise and greater opportunity for the underlying engine to optimize.

### Trade-offs

Declarative systems hide implementation details, which can improve clarity but make performance less obvious. SQL is concise, but a short query can still trigger a costly execution plan.

Imperative code provides control but can expose too much mechanism and mutation.

### Mixing styles

Real applications mix both. A service might use imperative orchestration, declarative queries, and functional transformations.

### Common mistakes

- assuming declarative means "no execution model";
- writing complex imperative loops where a query or collection operation is clearer;
- using dense declarative expressions that hide important failure or performance behavior;
- choosing style for fashion rather than comprehension.

## Questions / Exercises

1. What does declarative code hide from the caller?
2. When is explicit imperative control preferable?
3. Exercise: rewrite one manual filtering loop as a declarative query or collection operation and compare readability.

## Connections

**Parent:** [Programming Paradigms](README.md).

**Related:** [Functional & Event-Driven Styles](02-functional-event-driven.md).
