# Coupling, Stability & Dependency Cost

## Wall Note / A4

```text
coupling is unavoidable
hidden + unstable coupling is expensive
```

**Key rule:** depend explicitly on the smallest stable knowledge needed.

## Detailed Notes

### Forms of coupling

Coupling can occur through:
- imports and types;
- database schemas;
- message formats;
- shared files;
- temporal ordering;
- global state;
- runtime service calls;
- deployment coordination.

No direct code import does not mean two components are independent.

### Stability

A stable dependency changes slowly and has a well-defined contract. Depending on volatile implementation details spreads change cost.

### Temporal coupling

If operation B only works after A, callers carry hidden workflow knowledge. Make sequencing explicit with APIs, state machines, or orchestration where practical.

### Data coupling

Shared schemas create coupling even across separate services. A database table used by many components can be a stronger contract than an API.

### Team and deployment coupling

If two services must always be changed and deployed together, they are operationally coupled regardless of repository boundaries.

### Common mistakes

- measuring coupling only through imports;
- using events to hide rather than reduce dependencies;
- shared database tables across supposedly independent services;
- generic shared libraries that force synchronized upgrades.

## Questions / Exercises

1. Give three kinds of coupling that do not appear as imports.
2. What makes a dependency stable?
3. Exercise: map compile-time, runtime, data, and deployment coupling for one feature.

## Connections

**Parent:** [Cohesion & Coupling](README.md).

**Related:** [Dependency Inversion](../02-solid/05-dip.md), [Software Architecture](https://github.com/YosrBennagra/software-architecture).
