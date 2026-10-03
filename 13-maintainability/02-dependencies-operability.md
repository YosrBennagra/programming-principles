# Dependency Health & Operability

## Wall Note / A4

```text
maintainability =
code changeability
+ dependency health
+ production operability
```

**Key rule:** software is maintained after deployment, not only in the editor.

## Detailed Notes

### Dependency cost

A dependency adds API surface, upgrades, transitive dependencies, security exposure, license considerations, compatibility, and operational knowledge.

Use dependencies when they remove substantial well-understood work, not for trivial convenience by default.

### Upgradeability

Keep versions observable, understand breaking-change policy, and avoid pinning indefinitely until emergency upgrades become huge projects.

### Operability

Health checks, metrics, traces, safe configuration, graceful shutdown, rollback, and clear runbooks reduce the cost of maintaining production systems.

### Ownership

Critical dependencies and operational paths need an owner. "Nobody knows why this exists" is a maintainability failure.

### Common mistakes

- dependency added for a tiny helper;
- no upgrade strategy;
- configuration known only by one engineer;
- services that cannot shut down gracefully;
- observability added only after incidents.

## Questions / Exercises

1. What costs come with a dependency?
2. Why is graceful shutdown a maintainability concern?
3. Exercise: audit one dependency for value, upgrade risk, and removal cost.

## Connections

**Parent:** [Maintainability](README.md).

**Related:** [Software Architecture](https://github.com/YosrBennagra/software-architecture).
