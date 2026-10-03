# Safe Refactoring Workflow

## Wall Note / A4

```text
baseline behavior
→ small structural change
→ verify
→ commit
→ repeat
```

**Key rule:** keep feedback fast enough that you know which change broke behavior.

## Detailed Notes

### Establish safety

Use tests, compilation, static analysis, type checks, snapshots, or targeted manual verification depending on the system. The goal is a reliable signal before changing structure.

### Small transformations

Rename before moving. Extract before redesigning. Move one responsibility at a time. Small diffs are easier to reason about, review, and revert.

### Separate concerns

Avoid mixing broad formatting, behavior changes, dependency upgrades, and structural refactoring in one patch unless inseparable.

### Validate architecture after refactoring

A refactor is not successful merely because tests pass. Confirm that dependency direction, ownership, naming, and navigation are actually better.

### Common mistakes

- giant cleanup PRs;
- changing behavior unintentionally;
- refactoring without a baseline signal;
- introducing a pattern before understanding the smell;
- keeping obsolete abstractions "just in case."

## Questions / Exercises

1. Why are small commits valuable during refactoring?
2. What can serve as a safety net besides unit tests?
3. Exercise: plan a five-step refactor of a large service without changing behavior.

## Connections

**Parent:** [Refactoring](README.md).

**Related:** [Code Smells](../14-code-smells/README.md).
