# 07 — Immutability

## Wall Note / A4

Immutable value = cannot change after construction.

Benefits:
- easier reasoning;
- safer sharing;
- fewer races;
- stable hash/equality;
- easier caching and rollback.

**Key rule:** prefer immutable values; isolate mutation where state change is truly required.

## Detailed Notes

### Why mutation is hard

Mutable state introduces time into reasoning: the same reference can mean different things at different moments.

When state is shared, correctness may depend on who changed it, in what order, and under which synchronization.

### Value objects

Dates, money, IDs, coordinates, configuration snapshots, and domain values are strong candidates for immutability.

Instead of changing an object, create a new value representing the new state.

### Collections

An immutable reference to a mutable collection is not deeply immutable. Exposing internal mutable collections can break encapsulation.

Use immutable/unmodifiable collections or defensive copies when ownership crosses boundaries.

### Immutability and concurrency

Immutable data can be shared safely without locks because readers cannot race with mutations. This simplifies concurrent and asynchronous systems.

### Costs

Immutability can create more allocations or copying. Persistent data structures and structural sharing can reduce those costs. Large mutable buffers can be appropriate in performance-critical local code.

### Common mistakes

- declaring a field final/readonly while the referenced object remains mutable;
- copying huge structures unnecessarily;
- forcing immutability into stateful algorithms where local mutation is clearer;
- returning internal mutable collections.

### Senior-level understanding

The strongest design is often **functional core, imperative shell**: keep business transformations as pure/immutable as possible and isolate I/O/mutation at boundaries.

## Questions / Exercises

1. Why does immutability reduce concurrency risk?
2. Shallow versus deep immutability?
3. What is defensive copying?
4. When can local mutation be the better choice?
5. Exercise: convert one mutable value object to an immutable design.
6. Exercise: identify an exposed mutable collection and fix ownership.

## Deep dives

- [Immutable Values & State Modeling](01-value-objects-state.md)
- [Functional Core & Controlled Mutation](02-functional-core-mutable-boundaries.md)

## Connections

**Related:** [Computer Science Concurrency](https://github.com/YosrBennagra/computer-science-fundamentals/tree/main/08-concurrency), [Defensive Programming](../12-defensive-programming/README.md).
