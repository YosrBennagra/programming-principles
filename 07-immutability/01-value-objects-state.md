# Immutable Values & State Modeling

## Wall Note / A4

```text
immutable value
= valid at creation
+ cannot change afterward
```

**Key rule:** model values as immutable when identity does not require in-place mutation.

## Detailed Notes

### Value semantics

A value object is defined by its content rather than object identity. Examples include money, dates, coordinates, email addresses, percentages, and IDs.

Immutability fits these concepts naturally because changing the value usually means producing a new value.

### Construction

Validate an immutable value when it is created. Once constructed, users of the type can rely on its invariant without repeatedly checking it.

### Equality

Immutable values work well as keys because equality and hash behavior remain stable after construction.

### State transitions

An immutable object can still model change:

```text
oldState
→ operation
→ newState
```

This makes transitions explicit and can support auditing, undo, or event-based reasoning.

### Costs

Copying very large structures can be expensive. Persistent data structures, structural sharing, builders, or localized mutable assembly can reduce the cost.

### Common mistakes

- treating final references to mutable objects as fully immutable;
- adding setters later "for convenience";
- copying huge object graphs without need;
- confusing immutable values with applications that never change state.

## Questions / Exercises

1. Identity versus value semantics?
2. Why are immutable values good hash keys?
3. Exercise: convert a mutable Money or DateRange model into an immutable validated value type.

## Connections

**Parent:** [Immutability](README.md).

**Related:** [Encapsulation](../06-abstraction-encapsulation/02-encapsulation-information-hiding.md), [Defensive Programming](../12-defensive-programming/README.md).
