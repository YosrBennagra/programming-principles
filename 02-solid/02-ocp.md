# Open/Closed Principle

## Wall Note / A4

```text
stable policy
+ known variation point
→ extend behavior without repeatedly rewriting the stable core
```

**Key rule:** create extension points around demonstrated variation, not imagined futures.

## Detailed Notes

### What

Software should often be open to adding behavior while stable code remains closed to repeated risky modification.

### How

Composition, polymorphism, configuration, rules tables, or data-driven behavior can isolate a real axis of variation.

### Example

If shipping price varies by carrier, a stable checkout policy can depend on a shipping-cost contract while carrier implementations vary independently.

### Trade-offs

Every extension point adds concepts. If there is only one behavior and no evidence of change, a direct implementation may be simpler.

### OCP versus YAGNI

OCP does not justify building plugin architectures for hypothetical future needs. Wait until real variation becomes visible, then extract the stable abstraction.

### Common mistakes

- interfaces for everything;
- switch statements treated as automatically wrong;
- speculative plugin systems;
- abstractions that require flags for every new case.

### Senior-level understanding

The goal is not "never modify existing code." The goal is to reduce risky repeated modification where the domain has a stable core and recurring variation.

## Questions / Exercises

1. What evidence justifies an extension point?
2. When is a switch simpler than polymorphism?
3. Exercise: identify one genuine axis of variation in a current system.

## Connections

**Parent:** [SOLID](README.md).

**Related:** [DRY, KISS & YAGNI](../03-simplicity/README.md).
