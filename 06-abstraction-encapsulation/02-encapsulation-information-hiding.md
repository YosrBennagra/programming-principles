# Encapsulation & Information Hiding

## Wall Note / A4

```text
encapsulation
= controlled access to state and behavior

information hiding
= callers do not depend on representation details
```

**Key rule:** protect invariants and keep representation changes local.

## Detailed Notes

### Encapsulation

Private fields are only a mechanism. True encapsulation means callers cannot place an object into invalid states or depend directly on internal representation.

### Information hiding

A component should reveal what clients need while keeping implementation decisions replaceable.

For example, a Money type can expose arithmetic and currency semantics without revealing whether it stores a decimal, scaled integer, or another representation.

### Collections and ownership

Returning a mutable internal collection leaks encapsulation. Callers can change state without going through the owning object's rules.

Use immutable views, copies, or controlled operations depending on performance and ownership needs.

### Encapsulation versus test access

Do not make internals public solely to unit-test implementation details. Prefer testing observable behavior or extracting a real collaborator when a boundary exists.

### Common mistakes

- getter/setter pairs for every field;
- exposing mutable collections;
- leaking persistence entities into every layer;
- public methods that bypass invariants;
- breaking encapsulation for tests.

## Questions / Exercises

1. Why are private fields not sufficient for encapsulation?
2. What is information hiding?
3. Exercise: redesign an object that exposes a mutable list so state changes stay controlled.

## Connections

**Parent:** [Abstraction & Encapsulation](README.md).

**Related:** [Object Ownership & Invariants](../01-oop-composition/01-ownership-invariants.md), [Immutability](../07-immutability/README.md).
