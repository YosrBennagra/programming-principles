# 14 — Code Smells & Anti-Patterns

## Wall Note / A4

A **smell** is evidence worth investigating, not proof of bad design.

Common smells:
- long method/class;
- duplicated knowledge;
- feature envy;
- primitive obsession;
- shotgun surgery;
- divergent change;
- long parameter list;
- hidden temporal coupling;
- god object;
- speculative generality.

**Key rule:** fix the underlying design pressure, not the smell label.

## Detailed Notes

### Long method / large class

Size can indicate mixed responsibilities, but a long cohesive algorithm may be clearer than many fragments. Ask whether the unit mixes abstraction levels or changes for unrelated reasons.

### Duplicated knowledge

Repeated business rules are dangerous because copies drift. Similar syntax serving different concepts may be acceptable.

### Feature envy

A method that repeatedly reads another object's data may belong closer to that data or indicate a missing domain operation.

### Primitive obsession

Using strings/integers for domain concepts can lose validation and meaning. Value types such as EmailAddress, Money, OrderId, or Percentage can preserve invariants.

### Shotgun surgery

One logical change requires edits across many modules. This points to scattered responsibility or duplicated knowledge.

### Divergent change

One module changes for many unrelated business reasons. This points to weak cohesion.

### God object

A central class owns excessive state, rules, coordination, and dependencies. It becomes a bottleneck for changes and testing.

### Speculative generality

Unused extension points, abstract base classes, flags, and generic frameworks exist “for future flexibility.” Remove them until real variation appears.

### Anti-patterns

Anti-patterns are recurring approaches with known negative consequences in context. Examples include service locator, shared mutable global state, swallowed exceptions, distributed monoliths, and cargo-cult abstractions.

### Common mistakes

- treating every smell as mandatory refactoring;
- replacing simple code with a design pattern just to remove a smell;
- using static-analysis warnings without understanding context;
- naming an anti-pattern instead of explaining its concrete consequence.

### Senior-level understanding

A smell starts a conversation: **what future change is expensive here, and why?** Refactor only when the expected benefit exceeds the migration and complexity cost.

## Questions / Exercises

1. Why is a smell not automatically a defect?
2. Shotgun surgery versus divergent change?
3. What is primitive obsession?
4. What is speculative generality?
5. Exercise: identify three smells in a real module and rank them by actual change risk.
6. Exercise: refactor one smell without introducing unnecessary patterns.

## Deep dives

- [Structural Code Smells](01-structural-smells.md)
- [Behavioral & Architectural Smells](02-behavioral-architectural-smells.md)

## Connections

**Specialized continuation:** [Design Patterns](https://github.com/YosrBennagra/design-patterns) when a concrete refactoring problem genuinely calls for a pattern.

**Prerequisites:** [Maintainability](../13-maintainability/README.md), [Refactoring](../11-refactoring/README.md).

**Patterns:** consult the dedicated design-pattern repository from the [Software Engineer Roadmap](https://github.com/YosrBennagra/software-engineer-roadmap) only when a pattern addresses a demonstrated problem.
