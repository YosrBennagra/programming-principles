# KISS, YAGNI & Complexity Budget

## Wall Note / A4

```text
every abstraction has a carrying cost

build for known constraints
not imagined futures
```

**Key rule:** add complexity only when it pays for a real problem.

## Detailed Notes

### KISS

Simple code minimizes the number of concepts required to understand and change behavior. Simplicity is not the same as short code.

A direct implementation can be simpler than a generic framework even when it has more lines.

### YAGNI

Do not build extension points, configuration switches, distributed components, or generic abstractions for requirements that do not exist yet.

### Complexity budget

Every system has limited cognitive capacity. New layers, patterns, dependencies, configuration, and runtime components consume that budget.

Spend complexity where constraints demand it:
- security;
- correctness;
- scale;
- multiple real variants;
- operational resilience.

### Reversible decisions

Prefer simple reversible choices early. Delay expensive irreversible design commitments until requirements are clearer.

### Common mistakes

- "future-proofing" through speculative abstractions;
- measuring simplicity by line count;
- using YAGNI to ignore a known near-term constraint;
- replacing explicit business logic with overly generic engines.

## Questions / Exercises

1. What makes complexity justified?
2. Why can a longer implementation be simpler?
3. Exercise: remove one extension point that has no current user or requirement.

## Connections

**Parent:** [DRY, KISS & YAGNI](README.md).

**Related:** [Open/Closed Principle](../02-solid/02-ocp.md), [Senior Synthesis](../15-senior-synthesis/README.md).
