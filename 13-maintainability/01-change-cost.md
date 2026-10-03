# Change Cost, Blast Radius & Deletability

## Wall Note / A4

```text
small requirement
should cause
small understandable change
```

**Key rule:** a maintainable system keeps change amplification proportional to the requirement.

## Detailed Notes

### Change amplification

If one business rule requires editing controllers, services, repositories, jobs, frontend code, and duplicated validators, knowledge is scattered.

Track how many modules, teams, deployables, and tests must change for one concept.

### Blast radius

Blast radius includes more than changed files. It includes runtime dependencies, data migrations, deployment coordination, and failure impact.

### Deletability

A feature that can be removed cleanly usually has clear ownership and boundaries. Removal difficulty is a useful coupling signal.

### Local reasoning

Good modules expose enough contracts that engineers can make a safe change without reading the entire system.

### Common mistakes

- counting lines instead of change surfaces;
- shared utility modules that become universal dependencies;
- duplicated policy across layers;
- features that cannot be disabled or removed independently.

## Questions / Exercises

1. What is change amplification?
2. Why is deletability a design test?
3. Exercise: map the blast radius of changing one pricing rule.

## Connections

**Parent:** [Maintainability](README.md).

**Related:** [Cohesion & Coupling](../05-cohesion-coupling/README.md).
