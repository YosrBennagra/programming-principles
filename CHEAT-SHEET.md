# Programming Principles — Cheat Sheet

> One-page revision. Deep notes live in the numbered folders. Hub: [software-engineer-roadmap](https://github.com/YosrBennagra/software-engineer-roadmap)

## Paradigms
| Style | One line |
|---|---|
| Imperative | describe HOW state changes |
| Declarative | describe WHAT result you want (SQL, streams, templates) |
| OOP | objects own state + behaviour + invariants |
| Functional | pure functions over immutable values, effects at the edges |
| Event-driven | event → handler → effect; decouples timing, spreads the flow |

## SOLID (about change pressure, not class count)
| | Rule | Smell when broken |
|---|---|---|
| **S**RP | one cohesive *reason to change* | "Manager"/"Util" god class |
| **O**CP | extend at a *known* variation point, keep the core stable | same `switch` edited for every new type |
| **L**SP | subtype keeps the parent contract (pre/post-conditions, invariants) | `UnsupportedOperationException` in override |
| **I**SP | clients depend only on what they use | fat interface, empty impls |
| **D**IP | policy owns the contract; infrastructure implements it | domain imports JPA/HTTP/vendor types |

## Simplicity
- **DRY** = one source of truth per piece of *knowledge*. Same text ≠ same knowledge.
- **KISS** = simplest design that meets the *real* constraints.
- **YAGNI** = no speculative capability; every abstraction has a carrying cost.
- Remove *accidental* complexity, keep *essential* (domain) complexity.

## Design core
| Concept | One line |
|---|---|
| Cohesion | things that change together live together (aim HIGH) |
| Coupling | what you must know about others (aim LOW + explicit + stable) |
| Abstraction | small stable contract, hides volatile detail |
| Encapsulation | state changes only through methods that keep invariants |
| Separation of concerns | transport ≠ orchestration ≠ business policy ≠ persistence |
| Composition > inheritance | HAS-A for reuse/variation; IS-A only when substitutable |
| Law of Demeter | don't reach through `a.getB().getC()`; heuristic, not a ban |
| Tell, Don't Ask | ask the owner of the invariant to enforce it |
| Immutability | valid at creation, never changes → safe sharing, no races |
| Functional core / imperative shell | pure decisions inside, I/O at the edges |
| DIP vs DI | DIP = dependency *direction*; DI = *supplying* deps from outside |
| Constructor injection | required deps visible, final fields, easy to test |
| CQS (method level) | a method either changes state or returns data, not both |

## Clean code
- Names = domain intent + unit/constraint (`timeoutMs`, `activeCustomers`).
- Function: one purpose, one abstraction level, visible side effects, clear happy path.
- Comments explain **WHY** / constraints / decisions, not WHAT.
- Optimise for local reasoning, not for an arbitrary line count.

## Errors & defensive code
```
programmer bug | domain rejection | expected operational | transient dep | permanent dep | resource
```
- Classify first, then decide: exception, result type, retry, or fail fast.
- Translate low-level errors at the ownership boundary and add context.
- Retry only idempotent / safe operations, with backoff + a limit.
- **Handle OR propagate.** Log once, where context is enough. Never swallow.
- Validate once where trust changes, then use strong internal types.
- Bound everything: input size, queues, retries, concurrency, time.
- Make invalid states unrepresentable (value objects, enums, factories).

## Refactoring loop
```
tests pin behaviour → small structural step → run tests → commit → repeat
```
- Refactoring = new structure, **same observable behaviour**.
- Legacy: observe → characterization tests → create seam → refactor → change behaviour later.
- Never mix a behaviour change and a cleanup in the same commit.

## Code smells → what they usually mean
| Smell | Usually means |
|---|---|
| Shotgun surgery | one change touches many files → knowledge is scattered |
| Divergent change | one class changes for many reasons → split by responsibility |
| Feature envy | logic lives far from its data → move behaviour |
| Primitive obsession | `String email`, `BigDecimal price` → value objects |
| Long parameter list | missing concept / parameter object |
| Temporal coupling | `init()` must be called first → constructor / builder |
| Speculative generality | interfaces with 1 impl and no boundary → inline |
| Service locator / global state | hidden dependencies → inject explicitly |

## Senior gotchas
- One interface per class is ceremony. Abstract at real boundaries: I/O, vendors, ownership, actual variation.
- DRY across bounded contexts can create coupling. Duplication is sometimes the cheaper option.
- OCP vs YAGNI: add the extension point after the **second** real variation, not before.
- Over-splitting for SRP hurts navigability. Measure by change locality.
- `@Transactional` self-invocation bypasses the proxy (Spring), so the "principle" depends on the framework mechanics.
- Maintainability = code changeability + dependency health + operability + deletability.

## When to use what
| Situation | Reach for |
|---|---|
| Behaviour varies by type at runtime | Strategy / polymorphism |
| Rule depends on object state | put it in that object (Tell, Don't Ask) |
| Talking to DB / HTTP / vendor | port interface owned by the domain + adapter |
| Value with rules (money, email) | immutable value object |
| Untested legacy | characterization tests before touching anything |
| Two principles conflict | name the change you are protecting and the downside you accept |

**Senior questions:** What changes? Who owns it? What must stay invariant? Which way should dependencies point? What complexity am I adding vs removing?
