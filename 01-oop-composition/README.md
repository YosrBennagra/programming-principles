# 01 — OOP & Composition

## Wall Note / A4

Good OOP:
- clear ownership;
- hidden invariants;
- behavior near the data it governs;
- small collaborations.

Prefer:

```text
composition: HAS-A
over inheritance: IS-A
when behavior varies
```

**Key rule:** use inheritance only when substitutability is real; use composition for flexible behavior assembly.

## Detailed Notes

### Objects as responsibility boundaries

An object should represent a coherent responsibility and protect valid state transitions. Encapsulation matters more than creating getters and setters around every field.

Bad model:

```text
Order has public setters for status, total, paymentState...
Anyone can create impossible combinations.
```

Better model:

```text
Order.pay(...)
Order.cancel(...)
Order.ship(...)
```

The object owns its invariants.

### Composition

Composition builds behavior by collaborating with other objects. A service can receive a PricingPolicy, PaymentGateway, or Clock instead of inheriting behavior from a rigid hierarchy.

Benefits:
- behavior can vary independently;
- dependencies are explicit;
- easier testing;
- fewer fragile base-class assumptions.

### Inheritance

Inheritance can be appropriate when:
- the subtype truly satisfies the parent contract;
- substitutability is stable;
- shared behavior is intrinsic rather than convenience-only.

Inheritance becomes dangerous when subclasses override behavior just to work around the parent design.

### Polymorphism

Polymorphism lets clients depend on a stable contract while implementations vary. Prefer domain-relevant interfaces rather than one-interface-per-class ceremony.

### Anemic versus overstuffed models

An **anemic model** stores data while all rules live elsewhere. An **overstuffed object** owns unrelated responsibilities. Healthy models put important invariants close to state while orchestration and external I/O remain in appropriate collaborators.

### Common mistakes

- deep inheritance trees;
- getters/setters presented as encapsulation;
- utility/service classes containing all business behavior;
- inheritance for code reuse only;
- interfaces with only one implementation and no meaningful boundary;
- “god objects” that know everything.

### Senior-level understanding

OOP should reduce the number of places where a change must be understood. Model ownership and invariants before class hierarchies.

## Questions / Exercises

1. Composition versus inheritance?
2. What is substitutability?
3. Why are getters/setters not automatically encapsulation?
4. When is an anemic model acceptable?
5. Exercise: replace one inheritance relationship with composition.
6. Exercise: identify an invariant and move behavior closer to the state it protects.

## Connections

**Prerequisite:** [Programming Paradigms](../00-paradigms/README.md).

**Related:** [SOLID](../02-solid/README.md), [Abstraction & Encapsulation](../06-abstraction-encapsulation/README.md).
