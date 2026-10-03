# 11 — Refactoring

## Wall Note / A4

Refactoring = **change internal structure without changing observable behavior**.

Safe loop:

```text
protect behavior with tests
→ small change
→ run tests
→ commit
→ repeat
```

**Key rule:** separate behavior change from structural cleanup whenever practical.

## Detailed Notes

### Why refactor

Refactoring reduces change cost. Typical goals:
- reveal intent;
- isolate responsibilities;
- remove duplication;
- reduce coupling;
- improve testability;
- simplify control flow;
- create a boundary before adding a feature.

### Small steps

Large rewrites combine too many risks. Small transformations preserve feedback:
- rename;
- extract function/class;
- inline needless abstraction;
- move behavior;
- introduce parameter object;
- split phase;
- replace conditional with explicit strategy when variation is real.

### Characterization tests

Legacy code may lack tests. Characterization tests capture current behavior—even imperfect behavior—so structure can change safely before business behavior is modified intentionally.

### Refactoring versus rewriting

Rewriting discards working implementation knowledge and often reintroduces old bugs. A rewrite can be justified when constraints fundamentally change or the current system cannot be evolved safely, but it needs migration and validation strategy.

### Refactoring debt

Continuous small refactoring keeps design aligned with current understanding. Waiting for a giant “cleanup sprint” usually allows debt to compound.

### Common mistakes

- mixing refactor and feature changes in one huge diff;
- changing behavior unintentionally;
- refactoring without tests or other safety checks;
- applying patterns mechanically;
- rewriting because existing code feels ugly;
- optimizing aesthetics instead of change cost.

### Senior-level understanding

Refactoring is the mechanism that lets design evolve after requirements become clearer. Good engineers do not expect the first design to be final.

## Questions / Exercises

1. Refactoring versus rewriting?
2. What is a characterization test?
3. Why are small steps safer?
4. When should refactoring happen before a feature?
5. Exercise: take one large method and refactor in behavior-preserving commits.
6. Exercise: identify and remove one abstraction that no longer pays for itself.

## Deep dives

- [Safe Refactoring Workflow](01-safe-workflow.md)
- [Legacy Code & Characterization](02-legacy-code.md)

## Connections

**Prerequisites:** [Clean Code](../09-clean-code/README.md), [Simplicity](../03-simplicity/README.md).

**Related:** [Code Smells](../14-code-smells/README.md), [Maintainability](../13-maintainability/README.md).
