# Case 5 — Maintainability Review

## Scenario

A feature request says: "Add a new discount category."

The change requires edits in:
- two controllers;
- three services;
- one SQL script;
- two frontend mappings;
- one scheduled job;
- a CSV export;
- a shared constants file.

No single module clearly owns discount policy.

## Review questions

### Knowledge location

Where is the business rule defined? If the answer is "everywhere," the primary problem is scattered knowledge.

### Change amplification

Which edits are:
- unavoidable because the feature truly crosses boundaries?
- duplicated policy that should be centralized?
- representation mappings that can remain separate?
- symptoms of missing ownership?

### Coupling

Does the same enum/constants package force every consumer to change together? Would a stable domain capability reduce blast radius?

### Deletability

Could one discount category be removed without searching the entire codebase? If not, ownership is weak.

## Better direction

A maintainable design may:
- centralize discount eligibility/calculation in one policy-owned module;
- keep transport-specific representations local;
- preserve separate frontend/API mapping where duplication reflects independent contracts;
- publish stable outputs rather than leaking internal enum structure everywhere.

## What not to do

Do not automatically:
- create a shared library used by every service;
- move all logic into one giant DiscountManager;
- unify all models into one universal DTO;
- introduce a rules engine without evidence of enough rule volatility.

## Exercise

Map the feature change as a graph.

For every touched node, classify it as:
- policy owner;
- required adapter/mapping;
- accidental duplication;
- operational consequence.

Then propose a design that reduces **knowledge duplication** without creating unnecessary runtime or deployment coupling.

## Connections

[Change Cost](../13-maintainability/01-change-cost.md) · [DRY](../03-simplicity/01-dry-knowledge-duplication.md) · [Coupling](../05-cohesion-coupling/02-coupling-stability.md)
