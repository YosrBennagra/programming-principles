# Validation & Trust Boundaries

## Wall Note / A4

```text
external / untrusted data
→ validate once at boundary
→ convert to strong internal representation
```

**Key rule:** validate where trust changes, then avoid scattering the same checks everywhere.

## Detailed Notes

### Trust boundaries

Inputs become untrusted when they cross from:
- users;
- external APIs;
- files;
- queues;
- weakly constrained databases;
- environment/configuration;
- other services.

The boundary should reject malformed or unauthorized input before it contaminates internal state.

### Syntactic versus semantic validation

Syntactic validation asks whether data is structurally valid.

Semantic validation asks whether it is meaningful in the domain.

Examples:
- JSON parses: syntactic;
- quantity is positive: semantic;
- user may cancel this order: authorization/business rule.

### Strong types

Convert validated primitives into types that preserve meaning, such as EmailAddress, Money, OrderId, or DateRange.

This reduces repeated validation and makes illegal combinations harder to represent.

### Database constraints

Critical invariants such as uniqueness or referential integrity often deserve database enforcement in addition to application behavior because multiple code paths may write data.

### Common mistakes

- validation duplicated in every layer;
- trusting a third-party payload because it has a schema;
- stringly typed internal models;
- application-only uniqueness checks under concurrency;
- treating authorization as ordinary field validation.

## Questions / Exercises

1. What changes at a trust boundary?
2. Syntactic versus semantic validation?
3. Exercise: design validation flow for an order request from HTTP JSON to domain types.

## Connections

**Parent:** [Defensive Programming](README.md).

**Related:** [Object Ownership & Invariants](../01-oop-composition/01-ownership-invariants.md), [Application Security](https://github.com/YosrBennagra/application-security).
