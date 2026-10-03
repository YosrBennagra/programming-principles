# Error Logging & Observability

## Wall Note / A4

```text
handle OR propagate
log where context is sufficient and duplication stops
```

**Key rule:** logs should make failures diagnosable without leaking sensitive data or producing duplicate noise.

## Detailed Notes

### Logging location

Logging at every catch layer creates repeated stack traces for one failure. Prefer logging near the boundary where the failure is finally handled or converted into an external response.

### Context

Useful error context includes request or correlation ID, operation, safe entity identifiers, dependency, attempt count, and relevant state category.

Never log passwords, tokens, secrets, or unnecessary personal data.

### Metrics and traces

Logs explain individual events. Metrics reveal rate and impact. Traces connect failures across service boundaries. Mature systems use all three.

### Alertability

Not every exception deserves an alert. Alert on user or system impact, sustained error rates, exhausted resources, or broken invariants rather than raw log volume.

### Common mistakes

- duplicate logs at every layer;
- logging sensitive payloads;
- alerts on every isolated exception;
- swallowing context to keep messages short;
- no correlation between distributed calls.

## Questions / Exercises

1. Where should an exception normally be logged?
2. Metrics versus logs versus traces?
3. Exercise: define safe structured fields for one failed API request.

## Connections

**Parent:** [Error Handling](README.md).

**Related:** [Maintainability](../13-maintainability/README.md).
