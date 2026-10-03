# Legacy Code & Characterization

## Wall Note / A4

```text
unknown behavior
→ observe
→ characterize
→ create seam
→ refactor
→ intentionally change behavior later
```

**Key rule:** preserve what the system actually does before deciding what it should do.

## Detailed Notes

### Characterization tests

A characterization test records current externally visible behavior. It can protect strange behavior temporarily while structure is improved.

### Finding seams

A seam is a place where behavior can be changed or substituted without rewriting everything. Examples include extracting pure calculations, wrapping an external dependency, or introducing a narrow interface around I/O.

### Incremental migration

Prefer strangling or replacing bounded pieces when a full rewrite would carry high migration risk. Keep old and new paths comparable until confidence is established.

### When rewriting is justified

A rewrite may make sense when constraints fundamentally changed, the old platform is unsupported, or safe incremental evolution is impossible. Even then, define compatibility, data migration, rollback, and validation.

### Common mistakes

- rewriting because code looks ugly;
- treating current behavior as automatically correct;
- no migration or rollback plan;
- changing behavior while characterization coverage is still incomplete.

## Questions / Exercises

1. What does a characterization test protect?
2. What is a seam?
3. Exercise: identify the first safe seam in a legacy service.

## Connections

**Parent:** [Refactoring](README.md).

**Related:** [Maintainability](../13-maintainability/README.md).
