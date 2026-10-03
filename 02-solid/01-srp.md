# Single Responsibility Principle

## Wall Note / A4

```text
one module
→ one cohesive change driver
```

**Key rule:** SRP is about reasons to change, not the number of methods.

## Detailed Notes

### What

A module should group behavior that changes for the same underlying reason. Pricing policy, persistence format, email presentation, and authorization usually have different change drivers.

### Why

When unrelated responsibilities live together, small changes create larger review and regression surfaces. The module accumulates unrelated dependencies and becomes harder to test.

### How

Look for clusters of methods and dependencies that respond to different stakeholders or policies. Split only where the boundary is meaningful.

### Trade-offs

Over-splitting creates navigation cost and ceremony. A cohesive class with several methods can still satisfy SRP.

### Common mistakes

- one method per class;
- splitting by technical action rather than business responsibility;
- using "manager" classes as dumping grounds;
- moving code without reducing change coupling.

### Senior-level understanding

Ask: "If this requirement changes, what else must I understand?" SRP is successful when a change stays local for a clear reason.

## Questions / Exercises

1. What is a "reason to change"?
2. Why can a large class still be cohesive?
3. Exercise: identify independent change drivers in one service class.

## Connections

**Parent:** [SOLID](README.md).

**Related:** [Separation of Concerns](../04-separation-of-concerns/README.md), [Cohesion & Coupling](../05-cohesion-coupling/README.md).
