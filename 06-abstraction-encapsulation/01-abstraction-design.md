# Designing Good Abstractions

## Wall Note / A4

```text
good abstraction:
captures stable concept
hides volatile detail
preserves important behavior
```

**Key rule:** an abstraction should remove mental load without hiding facts callers need for correctness.

## Detailed Notes

### Stable concepts

Useful abstractions represent a stable capability such as "store order," "charge payment," or "calculate exchange rate."

Weak abstractions mirror an implementation exactly and provide little independence.

### Compression of knowledge

An abstraction earns its cost when callers no longer need to know:
- protocol details;
- storage mechanics;
- algorithm internals;
- vendor-specific structures.

### Leaky abstractions

Some details cannot safely be hidden:
- remote latency;
- transaction boundaries;
- eventual consistency;
- partial failure;
- memory ownership.

Pretending these do not exist produces dangerous APIs.

### Wrong abstractions

A wrong abstraction accumulates flags, special cases, subtype checks, and exceptions because the grouped behaviors were never truly the same concept.

Deleting or splitting it can be better than adding another option.

### Common mistakes

- abstraction for every concrete class;
- generic interfaces before variation is understood;
- hiding network calls behind APIs that look local and cheap;
- using inheritance as abstraction by default.

## Questions / Exercises

1. What makes an abstraction stable?
2. What behavior should a remote-call abstraction still reveal?
3. Exercise: find one abstraction with multiple boolean flags and decide whether it should be split or removed.

## Connections

**Parent:** [Abstraction & Encapsulation](README.md).

**Related:** [Dependency Inversion](../02-solid/05-dip.md), [KISS & YAGNI](../03-simplicity/02-kiss-yagni-complexity-budget.md).
