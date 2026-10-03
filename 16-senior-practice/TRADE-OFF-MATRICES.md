# Senior Trade-off Matrices

These are decision prompts, not universal rankings.

## Abstraction

| Choice | Benefit | Cost | Use when |
|---|---|---|---|
| Direct concrete dependency | simple, obvious | harder replacement/testing if volatile | stable/local dependency |
| Narrow interface | isolates real boundary | extra concept | external/volatile capability |
| Generic extension framework | flexible | high cognitive cost | many proven variants with shared model |

## Reuse

| Choice | Benefit | Cost | Use when |
|---|---|---|---|
| Duplicate small code | independence | drift risk | concepts only look similar |
| Shared function/module | single implementation | coupling | same knowledge changes together |
| Shared package across services | consistency | release/version coupling | strong ownership and stable contract |
| Remote service | independent deployability | latency/failure/ops cost | capability truly needs runtime ownership |

## State

| Choice | Benefit | Cost | Use when |
|---|---|---|---|
| Mutable object | efficient local updates | harder reasoning if shared | tightly owned state |
| Immutable value | strong invariants, safe sharing | copying/allocation | value semantics |
| Global mutable state | easy access | hidden coupling | almost never; very constrained infrastructure only |

## Error representation

| Choice | Benefit | Cost | Use when |
|---|---|---|---|
| Typed result | explicit expected outcomes | more plumbing | normal domain alternatives |
| Exception | non-local failure propagation | hidden control path if abused | exceptional/operational failure |
| Null/sentinel | minimal syntax | ambiguous semantics | only when domain meaning is truly unambiguous |

## Tests

| Choice | Benefit | Cost | Use when |
|---|---|---|---|
| Pure unit test | fast, precise | limited boundary coverage | deterministic rules |
| Fake-based test | realistic behavior | fake maintenance | stable boundary with simple semantics |
| Mock interaction test | verifies protocol | brittle if overused | interaction itself is contract |
| Integration test | catches real integration issues | slower/setup cost | persistence, messaging, adapters |

## Senior exercise

Take one real design decision and fill out:
- constraints;
- chosen row;
- rejected alternatives;
- accepted downside;
- signal that would trigger redesign.
