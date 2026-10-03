# Composition, Polymorphism & Inheritance

## Wall Note / A4

```text
composition → assemble collaborators
polymorphism → vary implementation behind a contract
inheritance → subtype relationship with behavioral obligations
```

**Key rule:** prefer composition for reuse and variation; use inheritance only for genuine substitutable subtypes.

## Detailed Notes

### Composition

Composition delegates work to collaborators. It allows behaviors to vary independently and keeps dependencies explicit.

Example: a PricingService can compose TaxPolicy and DiscountPolicy rather than inherit from a hierarchy combining every tax and discount combination.

### Polymorphism

Polymorphism lets code use a stable capability while implementations vary. The contract should represent meaningful domain behavior, not merely duplicate a concrete class API.

### Inheritance

Inheritance is strongest when:
- the subtype truly preserves the parent contract;
- the relationship is conceptually stable;
- callers benefit from substitution.

Using inheritance only for code reuse often creates fragile base classes.

### Delegation

Delegation is often simpler than inheritance because behavior can be replaced without changing type hierarchy.

### Common mistakes

- deep inheritance trees;
- abstract base classes created before variation exists;
- subclass overrides that disable parent behavior;
- interfaces with no meaningful client boundary;
- copying composition patterns so aggressively that simple code becomes indirect.

## Questions / Exercises

1. Why is code reuse alone weak justification for inheritance?
2. Composition versus delegation?
3. Exercise: flatten one inheritance hierarchy using composed policies.

## Connections

**Parent:** [OOP & Composition](README.md).

**Related:** [Liskov Substitution](../02-solid/03-lsp.md), [Dependency Inversion](../02-solid/05-dip.md).
