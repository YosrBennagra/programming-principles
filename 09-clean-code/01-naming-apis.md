# Naming & API Clarity

## Wall Note / A4

```text
good name = domain intent + relevant unit or constraint
```

**Key rule:** names should reduce the amount of implementation a reader must inspect.

## Detailed Notes

### Names encode contracts

Prefer names such as retryDelayMs, refundableAmount, or isEligibleForRefund over generic names like value, data, process, or check.

Units and important states belong in names or strong types where ambiguity is dangerous.

### Public APIs

A method signature should make valid use easy and invalid use difficult. Prefer domain types and cohesive parameter objects over strings and long primitive lists.

### Boolean parameters

Boolean arguments hide meaning at call sites. Two separate operations or a small enum often communicate intent better.

### Consistency

Use one term for one concept. If "customer," "client," and "account" mean different things, define that distinction; if they mean the same thing, standardize.

### Common mistakes

- abbreviations only the author understands;
- generic Helper or Manager names;
- implementation-focused names;
- misleading getters with side effects;
- boolean flags controlling unrelated behaviors.

## Questions / Exercises

1. Why are units important in names?
2. What is primitive ambiguity?
3. Exercise: improve the public API of a method with five primitive parameters.

## Connections

**Parent:** [Clean Code](README.md).

**Related:** [Abstraction & Encapsulation](../06-abstraction-encapsulation/README.md).
