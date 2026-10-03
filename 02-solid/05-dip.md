# Dependency Inversion Principle

## Wall Note / A4

```text
business policy
      ↓
application-owned contract
      ↑
database / vendor / framework detail
```

**Key rule:** stable high-level policy should not be shaped around volatile infrastructure details.

## Detailed Notes

### What

High-level modules and low-level details should depend on abstractions that express the policy's needs. The abstraction should usually be owned near the higher-level boundary.

### Example

A checkout use case needs "charge payment," not the full API of one payment vendor. A payment gateway contract can express the business-facing capability while the vendor adapter implements it.

### DIP versus DI

DIP is the dependency direction principle. Dependency injection is a construction technique for supplying collaborators. A DI container can be used while still violating DIP.

### Trade-offs

Not every library needs wrapping. Stable local utilities or standard library features often do not justify another abstraction.

### Common mistakes

- vendor types leaking through the abstraction;
- interface per class;
- confusing a DI framework with good dependency design;
- abstractions that mirror low-level APIs exactly.

### Senior-level understanding

Dependency direction should follow policy ownership. Volatile details are easiest to replace when they remain at the boundary.

## Questions / Exercises

1. DIP versus dependency injection?
2. Who should own the abstraction?
3. Exercise: redesign one direct vendor SDK dependency.

## Connections

**Parent:** [SOLID](README.md).

**Related:** [Dependency Inversion & Injection](../08-dependencies/README.md), [Software Architecture](https://github.com/YosrBennagra/software-architecture).
