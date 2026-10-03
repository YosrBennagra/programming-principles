# Policy, Orchestration & Infrastructure Boundaries

## Wall Note / A4

```text
transport
→ application orchestration
→ business policy
→ infrastructure adapters
```

**Key rule:** keep business decisions independent from delivery and storage details when those concerns change for different reasons.

## Detailed Notes

### Policy versus mechanism

Business policy answers questions such as:
- Is this operation allowed?
- What price applies?
- Which state transition is valid?

Infrastructure answers:
- How is data stored?
- How is a message sent?
- Which HTTP framework receives the request?

Mixing them forces business changes to understand technical details and vice versa.

### Orchestration

Application-level orchestration coordinates domain logic and external effects. It should not become a dumping ground for every business rule.

### Boundary value

A boundary is useful when it protects:
- a different rate of change;
- a different owner;
- a different failure model;
- a different technology;
- a different security concern.

### Over-layering

A layer that only passes arguments through unchanged may add no protection. Remove ceremonial layers that do not isolate meaningful change.

### Common mistakes

- framework annotations inside core business logic everywhere;
- repositories that contain business decisions;
- service classes that mix orchestration, rules, persistence, and formatting;
- layers created only because a template says so.

## Questions / Exercises

1. What is the difference between policy and mechanism?
2. When does a layer add no value?
3. Exercise: label transport, application, domain, and infrastructure responsibilities in one endpoint.

## Connections

**Parent:** [Separation of Concerns](README.md).

**Related:** [Dependency Inversion](../02-solid/05-dip.md), [Software Architecture](https://github.com/YosrBennagra/software-architecture).
