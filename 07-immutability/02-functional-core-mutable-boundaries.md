# Functional Core & Controlled Mutation

## Wall Note / A4

```text
I/O + mutable world
→ thin imperative shell
→ pure / immutable decision core
```

**Key rule:** isolate mutation where it is necessary; keep decision logic as deterministic as practical.

## Detailed Notes

### Functional core

A functional core receives data, applies rules, and returns decisions or new values without performing external I/O.

This makes business logic easy to test and reuse.

### Imperative shell

The outer layer:
- reads requests;
- loads state;
- calls the decision core;
- persists results;
- sends messages;
- handles retries and errors.

Effects remain explicit at the edge.

### Local mutation

Mutation inside a tightly owned local algorithm can be perfectly reasonable. The risk grows when mutable state escapes or becomes shared.

### Concurrency

Immutable messages are simpler to pass between threads or asynchronous tasks because readers cannot observe mid-update state.

### Performance

Do not allocate blindly in hot paths. Measure before replacing efficient local mutation with expensive copying.

### Common mistakes

- pursuing "purity" so aggressively that code becomes awkward;
- hiding I/O inside apparently pure methods;
- shared mutable caches without ownership rules;
- treating functional syntax as proof of functional behavior.

## Questions / Exercises

1. What belongs in a functional core?
2. When is local mutation acceptable?
3. Exercise: split one service method into pure decision logic plus an I/O shell.

## Connections

**Parent:** [Immutability](README.md).

**Related:** [Functional & Event-Driven Styles](../00-paradigms/02-functional-event-driven.md), [Concurrency Fundamentals](https://github.com/YosrBennagra/computer-science-fundamentals/tree/main/08-concurrency).
