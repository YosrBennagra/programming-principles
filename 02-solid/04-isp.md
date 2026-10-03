# Interface Segregation Principle

## Wall Note / A4

```text
client should depend on
the capabilities it actually needs
```

**Key rule:** shape contracts around consumers, not around one giant provider surface.

## Detailed Notes

### What

Large interfaces force clients and implementations to depend on methods they do not use. Focused contracts reduce accidental coupling.

### Client perspective

A reporting component that only reads invoices should not depend on an interface that also mutates, deletes, reconciles, and administers billing.

### How

Split by coherent capability when clients genuinely need different subsets. The contract should remain meaningful, not one method per interface by default.

### Trade-offs

Too many tiny interfaces increase fragmentation and naming overhead. If all clients use the same capability set, splitting creates no value.

### Common mistakes

- one interface per method;
- interfaces designed around implementation classes;
- exposing CRUD mega-interfaces everywhere;
- splitting contracts without reducing coupling.

### Senior-level understanding

ISP is useful when different clients evolve independently. Contract shape should reveal those independent needs.

## Questions / Exercises

1. What makes an interface "fat"?
2. When is splitting unnecessary?
3. Exercise: redesign a broad repository contract for read-only and write clients.

## Connections

**Parent:** [SOLID](README.md).

**Related:** [Cohesion & Coupling](../05-cohesion-coupling/README.md), [Dependencies](../08-dependencies/README.md).
