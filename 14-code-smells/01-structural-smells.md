# Structural Code Smells

## Wall Note / A4

```text
smell → investigate change pain
not → apply pattern automatically
```

**Key rule:** structural smells matter when they make expected changes harder.

## Detailed Notes

### Large class or method

Size is a signal, not a verdict. Investigate mixed abstraction levels, unrelated dependencies, and multiple change drivers.

### Long parameter list

This may indicate a missing domain concept, excessive orchestration, or an API carrying too much context.

### Primitive obsession

Strings and numbers representing domain concepts can spread parsing, validation, units, and invariants across the codebase.

### Feature envy

A method that mostly manipulates another object's data may be located on the wrong side of an ownership boundary.

### Shotgun surgery

One concept requires edits in many places. This often indicates scattered knowledge or weak modularity.

### Common mistakes

- splitting code solely because of line count;
- introducing value objects for every primitive;
- replacing one god class with dozens of anemic classes;
- refactoring without knowing which changes are actually expensive.

## Questions / Exercises

1. What does shotgun surgery reveal?
2. When is a long method acceptable?
3. Exercise: choose one smell and state the concrete change cost it creates.

## Connections

**Parent:** [Code Smells & Anti-Patterns](README.md).

**Related:** [Refactoring](../11-refactoring/README.md).
