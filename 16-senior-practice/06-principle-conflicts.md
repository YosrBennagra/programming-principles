# Case 6 — Principle Conflicts

Senior design becomes difficult when several valid principles point in different directions.

## Conflict 1 — DRY vs independent evolution

Two services contain the same 25-line validation rule.

Sharing it removes duplication, but creates a shared release dependency.

Ask:
- is this one domain rule that must remain identical?
- who owns it?
- would divergence be a bug or legitimate independent evolution?
- can the owner expose a stable contract instead of a shared library?

## Conflict 2 — OCP vs YAGNI

A team expects "maybe several pricing types later."

Do not build a plugin framework from a possibility alone.

A better approach:
- implement the current case clearly;
- isolate the decision enough to refactor safely;
- introduce an extension model when the second real variant reveals the axis of change.

## Conflict 3 — Encapsulation vs transparency

A repository method called save() hides:
- a network hop;
- distributed transaction-like semantics;
- retry and timeout behavior.

Hiding implementation is useful; hiding operational behavior callers must reason about is not.

## Conflict 4 — SRP vs navigability

Splitting a cohesive 250-line module into twelve tiny classes may reduce file size but increase cognitive load.

The correct question is not "How small?" but "Can one engineer understand the responsibility locally?"

## Conflict 5 — Immutability vs performance

Immutable values improve reasoning, but repeatedly copying very large structures in a hot path may be wasteful.

Use local controlled mutation when ownership is clear and measurement justifies it.

## Exercise

For each conflict:
1. choose one side under a specific scenario;
2. state the downside you accept;
3. state the signal that would make you reverse the decision.

## Connections

[Senior Synthesis](../15-senior-synthesis/README.md) · [Maintainability](../13-maintainability/README.md) · [Abstraction](../06-abstraction-encapsulation/README.md)
