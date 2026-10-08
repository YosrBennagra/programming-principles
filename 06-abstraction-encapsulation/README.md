# 06 — Abstraction & Encapsulation

## Wall Note / A4

- **Abstraction:** expose the essential model; hide irrelevant detail.
- **Encapsulation:** protect state/behavior behind a controlled boundary.

```text
good abstraction = small stable contract + hidden volatile details
```

**Key rule:** abstract around meaningful variation, not merely to add indirection.

## Detailed Notes

### Abstraction

A good abstraction lets callers think in domain terms. For example, `reserveInventory(order)` communicates intent better than exposing five storage calls.

Abstraction is successful when the hidden details can change without forcing callers to understand them.

### Leaky abstractions

No abstraction hides everything. A network repository may expose timeouts or eventual consistency indirectly. A database abstraction may still require transaction awareness.

A leaky abstraction is dangerous when it pretends important behavior does not exist.

### Encapsulation

Encapsulation prevents invalid manipulation. Fields being private is only one mechanism. The real goal is to preserve invariants and minimize the number of places that must understand internal representation.

### Abstraction level

Functions become harder to read when they mix levels:

```text
calculateInvoice()
openSocket()
parseProtocolFrame()
applyTaxRule()
```

Keep orchestration at one conceptual level and delegate lower-level details appropriately.

### Wrong abstractions

Duplicated code often gets merged into a generic abstraction too early. Later, callers need flags and special cases. That is evidence the commonality was superficial.

Removing a wrong abstraction can be better than extending it.

### Common mistakes

- interface = abstraction;
- private fields = complete encapsulation;
- hiding critical failure/latency behavior;
- creating generic “base” abstractions before variation exists;
- adding boolean flags to rescue an over-general abstraction.

### Senior-level understanding

A good abstraction compresses knowledge. It should remove concepts from the caller's mental load while preserving the information needed for correct decisions.

## Questions / Exercises

1. Abstraction versus encapsulation?
2. What makes an abstraction leaky?
3. Why can a network call hidden behind a repository interface still matter?
4. What is a wrong abstraction?
5. Exercise: simplify one generic abstraction that has accumulated flags.

## Deep dives

- [Designing Good Abstractions](01-abstraction-design.md)
- [Encapsulation & Information Hiding](02-encapsulation-information-hiding.md)
- [Law of Demeter & Tell, Don't Ask](03-law-of-demeter-tell-dont-ask.md)

## Connections

**Related:** [OOP & Composition](../01-oop-composition/README.md), [Simplicity](../03-simplicity/README.md), [Dependencies](../08-dependencies/README.md).
