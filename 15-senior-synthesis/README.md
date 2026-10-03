# 15 — Senior Synthesis: Principles as Trade-offs

## Wall Note / A4

Principles are constraints on complexity, not commandments.

Ask:

```text
What changes?
Who owns it?
What must stay invariant?
Where should dependency point?
What complexity am I adding?
What complexity am I removing?
How will I know the design is working?
```

**Key rule:** choose the simplest design that protects the most important expected changes and invariants.

## Detailed Notes

Senior-level design is the ability to balance principles when they pull in different directions.

### DRY versus decoupling

Two modules may duplicate a small rule intentionally to remain independently deployable. Sharing code can reduce textual duplication while increasing organizational or deployment coupling.

### OCP versus YAGNI

An extension point may make future changes easy, but if the variation is hypothetical it adds complexity today. Wait until evidence reveals the axis of variation.

### Encapsulation versus transparency

Encapsulation hides details, but hiding latency, transaction boundaries, or remote failure semantics can create a misleading abstraction. Hide implementation detail without hiding behavior callers must reason about.

### Small units versus navigability

Tiny functions/classes can create indirection. Cohesive medium-sized units may be easier to understand. Optimize for cognitive load, not a line-count metric.

### Reuse versus independence

Shared libraries improve consistency but couple release cycles. Copying small stable code may occasionally be cheaper than creating a cross-team dependency.

### Testability versus over-abstraction

Do not create dozens of interfaces only to mock internals. Test meaningful behavior at stable boundaries.

### A senior decision record

For a non-trivial design, write:
1. context and constraints;
2. decision;
3. alternatives considered;
4. trade-offs accepted;
5. signals that would cause reconsideration.

This turns principles into explainable engineering choices.

### Common mistakes

- citing principles instead of explaining consequences;
- declaring one rule always superior;
- optimizing for hypothetical scale;
- abstracting every external detail;
- refusing duplication even when boundaries should stay independent;
- adding patterns without a concrete problem.

### Senior-level understanding

The highest-level principle is **make change safe and reasoning local while preserving required behavior**. Everything else is a tool toward that goal.

## Questions / Exercises

1. Give a case where violating DRY improves architecture.
2. When should OCP yield to YAGNI?
3. What behaviors should an abstraction never hide?
4. Why can too many small classes reduce readability?
5. Exercise: write a one-page decision record for a current design choice and explicitly list principle conflicts.
6. Exercise: take one “best practice” in your codebase and state the conditions under which you would intentionally not use it.

## Continue practicing

Apply these conflicts to realistic design decisions in [Senior Practice: Design Judgment Under Constraints](../16-senior-practice/README.md).

## Connections

**Prerequisite:** complete the earlier sections.

**Continue with:** [Software Architecture](https://github.com/YosrBennagra/software-architecture), [Design Patterns](https://github.com/YosrBennagra/design-patterns), and [Computer Science Fundamentals](https://github.com/YosrBennagra/computer-science-fundamentals).
