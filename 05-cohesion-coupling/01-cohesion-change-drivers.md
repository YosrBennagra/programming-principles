# Cohesion & Change Drivers

## Wall Note / A4

```text
high cohesion
= related behavior + related data + related reasons to change
```

**Key rule:** modules should group knowledge that belongs together.

## Detailed Notes

### Functional cohesion

A module is cohesive when its contents contribute to one understandable responsibility or capability.

Signs of strong cohesion:
- dependencies serve the same purpose;
- methods operate on related state;
- changes usually affect the whole module for the same reason;
- naming is specific rather than generic.

### Weak cohesion

Warning signs:
- Utility, Manager, Common, or Helper classes containing unrelated behavior;
- subsets of methods using disjoint fields;
- a module importing unrelated technologies;
- several teams changing the same file for unrelated reasons.

### Change-driver test

Ask why each member of the module changes. If the answers differ significantly, the module may contain several responsibilities.

### Cohesion versus size

A large cohesive algorithm may be healthier than ten tiny classes with no clear ownership. Size is a signal, not the definition.

### Common mistakes

- splitting by line count;
- grouping code only by technical type;
- "shared" modules that become dumping grounds;
- tiny classes that scatter one concept across many files.

## Questions / Exercises

1. How does a change-driver test reveal weak cohesion?
2. Why is size not enough to judge cohesion?
3. Exercise: identify a low-cohesion class and group its behavior into coherent responsibilities.

## Connections

**Parent:** [Cohesion & Coupling](README.md).

**Related:** [Single Responsibility Principle](../02-solid/01-srp.md), [Maintainability](../13-maintainability/README.md).
