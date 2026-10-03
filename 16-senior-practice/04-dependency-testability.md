# Case 4 — Dependencies & Testability

## Scenario

A service has twelve mocked collaborators in every unit test. Small refactors break dozens of tests even when behavior is unchanged.

The team proposes adding more interfaces to "improve testability."

## Diagnose the real problem

Ask:
- are tests asserting public behavior or internal choreography?
- are dependencies meaningful boundaries or merely implementation pieces?
- does the class own too many responsibilities?
- could a fake replace several interaction mocks?
- is important logic pure enough to test without infrastructure?

## Better structure

Prefer:
- pure decision logic for business rules;
- explicit boundary abstractions for real external effects;
- a small number of high-value integration tests for adapters;
- fakes where realistic semantics are simple;
- mocks only where interaction itself is the behavior being protected.

## Example

Instead of mocking:
- repository.find;
- repository.save;
- mapper.map;
- clock.now;
- eventPublisher.publish;
- validator.validate;
- notifier.notify;

consider whether:
- validation belongs in a value/domain object;
- mapping is trivial and need not be mocked;
- clock is a real boundary if time affects decisions;
- repository can be represented by an in-memory fake;
- notification/event behavior belongs in an integration or orchestration test.

## Principle tension

- DIP favors dependency boundaries.
- KISS rejects interfaces with no design value.
- SRP may reveal why the class needs twelve collaborators.
- Testability is useful, but tests should not dictate an artificial production design.

## Exercise

Take a brittle unit test with at least five mocks.

Redesign it so:
- the behavior under test is clearer;
- no implementation-only collaborator is mocked;
- the smallest meaningful boundary is replaced with a fake/stub/mock;
- refactoring internal method calls would not break the test.

## Connections

[Boundary Abstractions & Test Doubles](../08-dependencies/02-boundary-abstractions-testing.md) · [Cohesion](../05-cohesion-coupling/01-cohesion-change-drivers.md) · [KISS/YAGNI](../03-simplicity/02-kiss-yagni-complexity-budget.md)
