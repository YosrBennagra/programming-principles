# 03 — DRY, KISS & YAGNI

## Wall Note / A4

- **DRY:** one source of truth for one piece of knowledge.
- **KISS:** prefer the simplest design that meets the real constraints.
- **YAGNI:** do not build speculative capability.

**Key rule:** remove accidental complexity, not necessary domain complexity.

## Detailed Notes

### DRY

DRY means **Don't Repeat Yourself**, but the important unit is knowledge, not text.

Two similar code blocks may represent different rules that happen to look alike today. Merging them prematurely can create harmful coupling.

Real DRY violations include:
- the same tax rule encoded in three places;
- duplicated validation rules that must change together;
- copied protocol constants;
- repeated mapping knowledge.

### KISS

Keep It Simple means minimize unnecessary moving parts. Simplicity is not shortness. A readable 20-line function can be simpler than a 5-line chain of clever abstractions.

Simple designs:
- expose fewer concepts;
- make control flow visible;
- reduce configuration;
- minimize dependency count;
- make failure behavior understandable.

### YAGNI

You Aren't Gonna Need It warns against building future flexibility without evidence.

Speculative abstraction creates:
- more code;
- more tests;
- more extension points;
- more concepts for maintainers;
- wrong guesses about future variation.

### Tension among the principles

Premature DRY can violate KISS and YAGNI. Sometimes a little duplication is cheaper until the true abstraction becomes visible.

A useful rule is **Rule of Three**: tolerate small duplication until repeated cases reveal stable common knowledge. It is a heuristic, not a law.

### Common mistakes

- extracting every duplicate line;
- measuring simplicity by line count;
- leaving known high-risk design debt under the excuse of YAGNI;
- building plugin systems for one implementation;
- using generic frameworks where a local function would work.

### Senior-level understanding

Simple systems are easier to change because they contain fewer assumptions. Delay irreversible abstraction until the shape of change is understood.

## Questions / Exercises

1. Why is duplicated code not always duplicated knowledge?
2. Give an example where DRY creates coupling.
3. What is the difference between simple and simplistic?
4. When is YAGNI not a valid excuse?
5. Exercise: remove one speculative abstraction.
6. Exercise: find duplicated business knowledge and consolidate it safely.

## Deep dives

- [DRY, Knowledge Duplication & Coupling](01-dry-knowledge-duplication.md)
- [KISS, YAGNI & Complexity Budget](02-kiss-yagni-complexity-budget.md)

## Connections

**Related:** [SOLID](../02-solid/README.md), [Refactoring](../11-refactoring/README.md), [Maintainability](../13-maintainability/README.md).
