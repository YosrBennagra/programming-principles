# 00 — Programming Paradigms

## Wall Note / A4

Paradigm = a dominant way to structure computation.

```text
imperative → tell the machine HOW
declarative → describe WHAT
OOP → objects + behavior + state
functional → values + functions + controlled effects
event-driven → react to events
concurrent → coordinate independent work
```

**Key rule:** choose the paradigm that makes the problem easiest to reason about.

## Detailed Notes

### Imperative and procedural

Imperative code describes state changes step by step. Procedural programming organizes those steps into procedures/functions.

It is direct and often ideal for algorithms, orchestration, and simple transformations. Its main risk is uncontrolled mutation spread across a large scope.

### Object-oriented

OOP groups state and behavior behind object boundaries. Strong OOP is not “everything must be a class”; it is about ownership, collaboration, encapsulation, and polymorphism where those ideas improve the model.

### Functional

Functional programming emphasizes pure functions, immutable values, composition, expressions, and controlled side effects. Pure functions are easy to test and reason about because output depends only on input.

Real systems are not purely functional because I/O and state exist, but functional techniques can isolate complexity.

### Declarative

Declarative code describes desired results while a system decides execution details. SQL, HTML, CSS, build definitions, and many configuration languages are examples.

Declarative approaches can reduce low-level control while improving clarity and optimization opportunities.

### Event-driven

Event-driven systems react to events rather than follow one centralized call sequence. This can decouple producers and consumers, but introduces ordering, lifecycle, error, and observability challenges.

### Multi-paradigm design

Most modern languages and systems mix paradigms. A Java/Spring application may use OOP for domain boundaries, functional transformations for collections, declarative annotations/configuration, event-driven messaging, and asynchronous concurrency.

### Common mistakes

- treating a language as belonging to only one paradigm;
- forcing OOP around stateless transformations;
- using functional style as dense clever syntax;
- hiding control flow behind excessive callbacks/events;
- selecting a paradigm for fashion rather than reasoning quality.

### Senior-level understanding

A paradigm is a tool for controlling complexity. Senior engineers mix paradigms deliberately and keep boundaries clear.

## Questions / Exercises

1. Imperative versus declarative: give one example of each.
2. Where does functional style improve testability?
3. When can event-driven code become harder to debug?
4. Why is modern Java multi-paradigm?
5. Exercise: rewrite one stateful transformation as a pure function.
6. Exercise: identify the paradigms used in one production request flow.

## Deep dives

- [Imperative & Declarative Programming](01-imperative-declarative.md)
- [Functional & Event-Driven Styles](02-functional-event-driven.md)

## Connections

**Prerequisites:** [Computer Science Fundamentals](https://github.com/YosrBennagra/computer-science-fundamentals).

**Next:** [OOP & Composition](../01-oop-composition/README.md).
