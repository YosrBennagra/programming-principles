# 02 — SOLID

## Wall Note / A4

- **S**RP — one cohesive reason to change.
- **O**CP — extend behavior without repeatedly rewriting stable code.
- **L**SP — subtypes preserve the contract.
- **I**SP — clients depend only on capabilities they need.
- **D**IP — high-level policy depends on abstractions, not volatile details.

**Key rule:** SOLID is about managing change and dependency pressure, not maximizing interfaces/classes.

## Detailed Notes

### Single Responsibility Principle

A module should have one cohesive reason to change. “One function only” is not the rule. Responsibilities are about change drivers.

If a class changes for pricing rules, database schema, email formatting, and authorization policy, it contains unrelated reasons to change.

### Open/Closed Principle

Stable code should often be extensible without repeated modification. Strategy objects, polymorphism, data-driven rules, and composition can help.

Do not pre-build extension points for imaginary requirements. OCP must coexist with YAGNI.

### Liskov Substitution Principle

If code works with a base type, any valid subtype should preserve the expected contract.

Violations often show up as:
- unsupported inherited methods;
- stronger input requirements;
- weaker output guarantees;
- surprising side effects.

### Interface Segregation Principle

Prefer focused contracts shaped around client needs. Large interfaces force clients and implementers to depend on unrelated capabilities.

This does not mean splitting every interface into one method.

### Dependency Inversion Principle

High-level policies should not depend directly on volatile infrastructure details. Both can depend on a stable abstraction owned near the policy boundary.

DIP is a design principle. Dependency injection is one implementation technique.

### Common mistakes

- “SRP means one method per class”;
- creating interfaces for every concrete class;
- abstracting before variation exists;
- using inheritance that violates LSP;
- confusing DIP with a DI framework;
- treating SOLID as five independent commandments.

### Senior-level understanding

SOLID becomes useful when you can name the actual change pressure: “payment providers vary,” “storage is infrastructure,” “pricing rules change independently,” “this subtype cannot honor the contract.”

## Questions / Exercises

1. Define each SOLID principle in practical terms.
2. DIP versus dependency injection?
3. Give an LSP violation that compiles successfully.
4. How can OCP conflict with YAGNI?
5. Exercise: take one service class and list its independent reasons to change.
6. Exercise: remove one unnecessary abstraction introduced only to “follow SOLID.”

## Connections

**Prerequisite:** [OOP & Composition](../01-oop-composition/README.md).

**Related:** [Dependencies](../08-dependencies/README.md), [Maintainability](../13-maintainability/README.md).

**Patterns:** use the dedicated design-pattern repository through the [Software Engineer Roadmap](https://github.com/YosrBennagra/software-engineer-roadmap); do not duplicate patterns here.
