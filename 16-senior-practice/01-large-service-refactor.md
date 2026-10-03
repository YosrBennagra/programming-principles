# Case 1 — Refactor an Overloaded Service

## Scenario

An OrderService has 2,400 lines and 14 dependencies. It:
- validates requests;
- calculates prices and discounts;
- checks authorization;
- persists orders;
- sends email;
- publishes events;
- calls inventory;
- formats audit messages;
- handles retries;
- maps API DTOs.

The team wants to "apply SOLID" by splitting it into 30 small services immediately.

## First mistake to avoid

Do not refactor from class size alone.

Ask which responsibilities:
- change for different reasons;
- own different invariants;
- depend on different external systems;
- need different tests;
- create different failure semantics.

## Refactoring path

A safer sequence might be:

1. characterize current behavior;
2. separate pure pricing/eligibility decisions;
3. extract transport mapping from application orchestration;
4. isolate persistence and external adapters;
5. make authorization ownership explicit;
6. leave cohesive orchestration together;
7. only create interfaces where a real boundary exists.

## Example target shape

```text
OrderController
  → PlaceOrderUseCase
      → PricingPolicy
      → InventoryGateway
      → OrderRepository
      → EventPublisher
```

Email may react to an order-created event if delayed delivery is acceptable; otherwise keep it explicit in the use case. The correct choice depends on semantics.

## Principle tension

- SRP suggests separating independent change drivers.
- KISS warns against 30 ceremonial classes.
- DIP supports isolating volatile external systems.
- YAGNI warns against abstractions for future providers that do not exist.
- DRY may conflict with keeping modules independently understandable.

## Exercise

Propose a refactoring plan with at most five new meaningful components.

For each:
- state the responsibility;
- state why it changes independently;
- name its dependencies;
- state whether it needs an interface and why;
- state the regression protection used during extraction.

## Connections

[SRP](../02-solid/01-srp.md) · [Separation of Concerns](../04-separation-of-concerns/README.md) · [Safe Refactoring](../11-refactoring/01-safe-workflow.md)
