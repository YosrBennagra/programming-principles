# Liskov Substitution Principle

## Wall Note / A4

```text
if B is a subtype of A,
clients using A should remain correct when given B
```

**Key rule:** inheritance is valid only when the subtype preserves the parent contract.

## Detailed Notes

### Contract compatibility

A subtype should not require stronger preconditions, provide weaker guarantees, or introduce surprising behavior that breaks callers' expectations.

### Typical violations

- inherited methods that throw "unsupported";
- subtype accepts fewer valid inputs;
- subtype changes important side effects;
- mutable subtype breaks assumptions of an immutable base contract.

### Why it matters

LSP violations create code that type-checks but fails conceptually. Callers need subtype checks, special cases, or defensive branching, defeating polymorphism.

### Composition alternative

When two types share some implementation but not the same behavioral contract, composition is often safer than inheritance.

### Common mistakes

- using inheritance only for code reuse;
- assuming "is-a" wording proves substitutability;
- defining vague base contracts;
- fixing violations with caller-side type checks.

### Senior-level understanding

LSP is fundamentally about **behavioral contracts**, not syntax. State the contract explicitly enough to judge substitution.

## Questions / Exercises

1. Stronger precondition versus weaker postcondition?
2. Why is "unsupported operation" a warning sign?
3. Exercise: find an inheritance hierarchy where composition is safer.

## Connections

**Parent:** [SOLID](README.md).

**Related:** [OOP & Composition](../01-oop-composition/README.md).
