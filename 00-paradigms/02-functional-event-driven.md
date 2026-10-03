# Functional & Event-Driven Styles

## Wall Note / A4

```text
functional:
input → pure transformation → output

event-driven:
event → handler → state change / effect
```

**Key rule:** functional style reduces hidden state; event-driven style decouples timing but makes flow more distributed.

## Detailed Notes

### Functional techniques

Useful functional ideas include:
- pure functions;
- immutable values;
- higher-order functions;
- function composition;
- explicit effects.

A pure function returns the same output for the same input and does not mutate externally visible state.

### Why purity helps

Pure transformations are easier to test, cache, parallelize, and reason about because there is less hidden context.

### Event-driven systems

Event-driven code reacts to events from users, queues, domain changes, timers, or infrastructure.

It can reduce direct coupling between producers and consumers, but the control flow becomes distributed across handlers.

### Event risks

Events introduce:
- ordering questions;
- duplicate delivery;
- lifecycle and subscription management;
- hidden side effects;
- debugging difficulty when causality spans many handlers.

### Senior concerns

A useful design often keeps a **functional core** for decision logic and an **imperative/event-driven shell** for I/O and effects.

### Common mistakes

- using functional syntax while still mutating hidden state;
- long chains that are harder to debug than simple statements;
- event buses used to hide coupling;
- events for local calls that need immediate direct answers.

## Questions / Exercises

1. What makes a function pure?
2. Why can event-driven flow be hard to debug?
3. Exercise: extract pure decision logic from an event handler that currently performs validation, state mutation, and I/O together.

## Connections

**Parent:** [Programming Paradigms](README.md).

**Related:** [Immutability](../07-immutability/README.md), [Separation of Concerns](../04-separation-of-concerns/README.md).
