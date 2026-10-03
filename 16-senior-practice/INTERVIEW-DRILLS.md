# Senior Interview Drills

For each answer:
- identify the actual design force;
- avoid slogans;
- compare at least two viable choices;
- state the accepted downside.

## Principles & boundaries

1. When does SRP justify splitting a class?
2. Give a case where a large class is still cohesive.
3. When should OCP yield to YAGNI?
4. Give an LSP violation that compiles.
5. When is an interface unnecessary?
6. Explain DIP without mentioning a DI framework.
7. What makes a boundary valuable?
8. When can duplication improve independence?

## Abstraction & modeling

9. What makes an abstraction "wrong" rather than merely imperfect?
10. What details should a remote-call abstraction never hide?
11. Why are getters/setters not equivalent to encapsulation?
12. When should a domain concept become a value object?
13. Composition versus inheritance: give a case where inheritance is correct.
14. When is local mutation preferable to immutable copying?

## Error handling

15. Domain rejection versus operational failure?
16. Where should infrastructure exceptions be translated?
17. Why can catching Exception be dangerous?
18. When is retry a business-level correctness risk?
19. Where should an exception be logged?
20. How do you model an ambiguous remote outcome?

## Refactoring & maintainability

21. What evidence tells you a refactor is worth doing?
22. Characterization test versus normal specification test?
23. How do you refactor a service with no tests?
24. What is change amplification?
25. Why is deletability a useful design property?
26. Give a case where removing an abstraction improves maintainability.

## Testability & dependencies

27. Why can too many mocks indicate a design problem?
28. Fake versus stub versus mock?
29. When should you wrap a third-party library?
30. Why is a DI container not proof of dependency inversion?

## Final synthesis

31. A feature touches 12 modules. How do you decide whether that is legitimate or a design smell?
32. A teammate wants one interface per class "for testing." How do you respond?
33. Two services duplicate the same validation. Should it be shared?
34. A 300-line method is easy to understand and rarely changes. Must it be split?
35. Design the smallest useful abstraction around a payment provider.
36. Explain one situation where following a clean-code rule mechanically makes the system worse.
