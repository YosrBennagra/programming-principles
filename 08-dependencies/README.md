# 08 — Dependency Inversion & Dependency Injection

## Wall Note / A4

```text
high-level policy
      ↓ depends on
stable contract
      ↑ implemented by
infrastructure detail
```

**DIP:** dependency direction principle.

**DI:** technique for supplying dependencies from outside.

**Key rule:** keep business policy independent of volatile infrastructure where that independence has value.

## Detailed Notes

### Dependency inversion

Without inversion:

```text
CheckoutService → StripeSdk
```

With a meaningful boundary:

```text
CheckoutService → PaymentGateway contract ← StripePaymentGateway
```

The contract should reflect what the application needs, not mirror the vendor API.

### Dependency injection

Dependencies can be injected through constructors, factories, method parameters, or a container.

Constructor injection is usually easiest to reason about because required dependencies are explicit and objects can be valid after construction.

### DI containers

Framework containers manage object creation and wiring. They are useful, but can hide the object graph if abused.

Avoid service-locator patterns where code asks a global container for arbitrary dependencies.

### Testing

DI helps testing because external effects can be replaced by fakes/stubs. But “testability” should not lead to mocking every internal object. Prefer tests around meaningful boundaries.

### When not to abstract

A stable library or local implementation may not need an interface. Abstract when there is a real boundary, volatility, ownership concern, side effect, or contract worth isolating.

### Common mistakes

- interface per class;
- DI solely because the framework encourages it;
- injecting dozens of dependencies into one service;
- leaking vendor types through the supposedly inverted contract;
- service locator hidden as a helper.

### Senior-level understanding

Dependency direction should follow policy ownership. High-level business rules should not be shaped around the details of storage, transport, or vendor SDKs.

## Questions / Exercises

1. DIP versus DI?
2. Why prefer constructor injection for required dependencies?
3. What is a service locator?
4. When is an interface unnecessary?
5. Exercise: redesign a direct vendor dependency around an application-owned contract.

## Deep dives

- [Constructor Injection & Object Graphs](01-constructor-injection-object-graphs.md)
- [Boundary Abstractions & Test Doubles](02-boundary-abstractions-testing.md)

## Connections

**Specialized continuation:** [Testing Engineering](https://github.com/YosrBennagra/testing-engineering) for test strategy and test-double depth.

**Prerequisites:** [SOLID](../02-solid/README.md), [Abstraction & Encapsulation](../06-abstraction-encapsulation/README.md).

**Architecture depth:** [Software Architecture](https://github.com/YosrBennagra/software-architecture).
