# Constructor Injection & Object Graphs

## Wall Note / A4

```text
application startup
→ build object graph
→ pass required collaborators explicitly
```

**Key rule:** required dependencies should be visible when an object is constructed.

## Detailed Notes

### Constructor injection

Constructor injection makes required collaborators explicit and helps guarantee the object is usable immediately after creation.

A class with twelve constructor dependencies often signals that it coordinates too many responsibilities.

### Object graph

The object graph is the network of instantiated components and their dependencies. Framework containers can build it, but engineers should still be able to understand its shape.

### Optional dependencies

If a dependency is truly optional, model that explicitly. Setter injection for mandatory collaborators creates partially initialized objects.

### DI containers

Containers are useful for:
- lifecycle management;
- configuration;
- wiring;
- scopes;
- decorators.

They should not become globally accessible service locators.

### Testing

Tests can construct the object with meaningful fakes or in-memory adapters. Avoid mocking every internal collaborator if a simpler behavioral test is possible.

### Common mistakes

- field injection hiding required collaborators;
- service locator calls from business logic;
- constructor dependency explosion ignored as normal;
- mocking implementation details instead of stable boundaries.

## Questions / Exercises

1. Why does constructor injection improve object validity?
2. What does a large constructor reveal?
3. Exercise: replace service-locator access with explicit dependencies in one component.

## Connections

**Parent:** [Dependency Inversion & Injection](README.md).

**Related:** [Dependency Inversion Principle](../02-solid/05-dip.md), [Cohesion](../05-cohesion-coupling/01-cohesion-change-drivers.md).
