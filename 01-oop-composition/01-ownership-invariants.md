# Object Ownership & Invariants

## Wall Note / A4

```text
object boundary
→ owns state
→ protects valid transitions
→ exposes behavior
```

**Key rule:** place rules near the state they must keep valid.

## Detailed Notes

### Ownership

An object or module should have a clear answer to: "Who is allowed to change this state?"

Without ownership, multiple services manipulate fields directly and invariants become duplicated.

### Invariants

An invariant is a rule that must remain true.

Examples:
- an order cannot ship before payment;
- a percentage remains within its domain range;
- a booking end time cannot precede its start time.

### Behavior-rich APIs

Prefer domain operations that preserve invariants:

```text
order.ship()
account.withdraw(amount)
subscription.cancel(reason)
```

over exposing arbitrary field setters.

### Encapsulation and persistence

Persistence frameworks can pressure models toward public setters or empty constructors. Infrastructure needs should not automatically determine the domain API exposed to the rest of the application.

### Aggregate boundaries

Some invariants involve several values or entities. Keep the consistency boundary as small as practical while ensuring the invariant has one clear owner.

### Common mistakes

- public setters for every field;
- validation duplicated in controller, service, and entity;
- business state changed directly by repository code;
- one giant object claiming ownership of unrelated rules.

## Questions / Exercises

1. What is state ownership?
2. Why are setters insufficient for invariant protection?
3. Exercise: redesign an Order model with explicit valid state transitions.

## Connections

**Parent:** [OOP & Composition](README.md).

**Related:** [Abstraction & Encapsulation](../06-abstraction-encapsulation/README.md), [Defensive Programming](../12-defensive-programming/README.md).
