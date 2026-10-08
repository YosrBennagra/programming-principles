# GRASP — Responsibility Assignment Crosswalk

GRASP (General Responsibility Assignment Software Patterns) describes **nine responsibility-assignment heuristics**. It does **not** require nine design layers or nine new pattern implementations. The established topic owners already explain most underlying mechanisms.

| Guideline | Useful decision | Deep owner |
|---|---|---|
| Information Expert | Put a rule near the information needed to preserve its invariant | [Ownership & invariants](../01-oop-composition/01-ownership-invariants.md) |
| Creator | Assign object construction based on lifecycle, aggregation or information ownership | [OOP & composition](../01-oop-composition/README.md); [creational patterns](https://github.com/YosrBennagra/design-patterns/tree/main/01-creational) |
| Controller | Let a cohesive use case receive a system operation, not an all-purpose controller | [Separation of concerns](../04-separation-of-concerns/01-policy-boundaries.md) |
| Low Coupling | Keep change impact local and dependency relationships intelligible | [Coupling & stability](../05-cohesion-coupling/02-coupling-stability.md) |
| High Cohesion | Group behavior whose change drivers belong together | [Cohesion](../05-cohesion-coupling/01-cohesion-change-drivers.md) |
| Polymorphism | Encapsulate **real** behavior variants behind meaningful contracts | [Composition & polymorphism](../01-oop-composition/02-composition-polymorphism.md) |
| Pure Fabrication | Introduce a non-domain helper only if it separates real technical responsibilities | [Separation of concerns](../04-separation-of-concerns/README.md) |
| Indirection | Add a middle layer only where it reduces meaningful dependency pressure | [DIP](../02-solid/05-dip.md); [Abstractions](../06-abstraction-encapsulation/README.md) |
| Protected Variations | Stabilize actual variation points; do not predict every future change | [OCP](../02-solid/02-ocp.md); [YAGNI](../03-simplicity/02-kiss-yagni-complexity-budget.md) |

## One exercise, not nine new abstractions

In a Spring checkout application, distinguish who owns pricing (Information Expert), who orchestrates the operation (Controller), and whether persistence deserves a boundary (Indirection/Pure Fabrication). Is Strategy justified by an actual second variant (Polymorphism/Protected Variations)?

Work through the [runnable checkout lab](labs/checkout-refactoring/README.md). Explain why **not** introducing a layer can be a correct GRASP-informed decision.
