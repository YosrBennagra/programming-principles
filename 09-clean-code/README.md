# 09 — Clean Code

## Wall Note / A4

Clean code optimizes for the next reader.

Prefer:
- intention-revealing names;
- small coherent units;
- explicit control flow;
- minimal hidden state;
- consistent boundaries;
- comments that explain **why**, not obvious **what**.

**Key rule:** readability is a design property, not formatting polish.

## Detailed Notes

### Names

Names should communicate domain intent and units. `timeoutMs` is safer than `timeout`. `isEligibleForRefund` is clearer than `check()`.

Avoid unnecessary abbreviations and generic words such as data, info, helper, manager, processor unless the domain meaning is genuinely generic.

### Functions

A function should operate at a coherent abstraction level and have a clear purpose. Small is useful when it improves comprehension, not as an arbitrary line limit.

Large parameter lists often indicate missing concepts or mixed responsibilities.

### Comments

Good comments explain:
- surprising constraints;
- external protocol reasons;
- invariants;
- non-obvious trade-offs;
- why a workaround exists.

Bad comments restate the code or compensate for unclear naming.

### Control flow

Prefer early returns and explicit branching when they reduce nesting. Avoid clever expressions that compress important decisions.

### Side effects

A function named `getUser` should not silently mutate unrelated state or send email. Make effects visible in names and boundaries.

### Consistency

Consistent naming, error behavior, module boundaries, and conventions reduce cognitive load. Automated formatting should handle style debates.

### Common mistakes

- measuring cleanliness by method length alone;
- too many tiny methods that force constant jumping;
- “cleaning” code by introducing unnecessary patterns;
- comments that become stale;
- hidden side effects;
- names that reflect implementation rather than domain intent.

### Senior-level understanding

Clean code reduces the number of concepts a reader must keep active at once. Optimize for local reasoning.

## Questions / Exercises

1. What makes a name intention-revealing?
2. When is a long function acceptable?
3. What belongs in comments?
4. Why are hidden side effects dangerous?
5. Exercise: rename one unclear service API and simplify its control flow.
6. Exercise: remove one comment by making the code express the intent.

## Connections

**Related:** [Maintainability](../13-maintainability/README.md), [Refactoring](../11-refactoring/README.md), [Code Smells](../14-code-smells/README.md).
