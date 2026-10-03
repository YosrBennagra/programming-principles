# Comments, Side Effects & Readability

## Wall Note / A4

```text
code explains WHAT
good comment explains WHY / constraint / decision
```

**Key rule:** make side effects visible and reserve comments for knowledge the code cannot express safely.

## Detailed Notes

### Comments

Useful comments capture external constraints, surprising decisions, non-obvious invariants, or reasons a simpler-looking approach is incorrect.

Comments that narrate obvious code become noise and drift out of date.

### Side effects

A function named getUser should not send email, mutate unrelated state, or trigger a remote write. Side effects should be visible through boundaries, names, or orchestration.

### Temporal knowledge

Comments often reveal hidden sequencing rules: "must call initialize first." Prefer an API or type design that makes valid sequencing explicit when practical.

### Readability

Readability includes control flow, naming, error behavior, data shape, and dependency visibility. Formatting is only the surface.

### Common mistakes

- TODO comments with no owner or context;
- comments compensating for poor names;
- hidden mutations in getters;
- side effects buried in mapping or stream operations;
- stale explanations after behavior changes.

## Questions / Exercises

1. What information belongs in comments?
2. Why are hidden side effects difficult to test?
3. Exercise: remove one explanatory comment by improving the design, and keep one comment that captures a real constraint.

## Connections

**Parent:** [Clean Code](README.md).

**Related:** [Maintainability](../13-maintainability/README.md).
