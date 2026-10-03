# Case 2 — Choose the Right Abstraction

## Scenario

Your application uses one payment provider. A developer proposes:

```text
PaymentProviderFactory
→ AbstractPaymentProvider
→ ProviderStrategy
→ ProviderAdapter
→ PaymentFacade
```

There is only one provider today and no committed plan for another.

## Questions before designing

- What volatility are we isolating?
- Which vendor details currently leak into business policy?
- What would actually change if the provider changed?
- Is testing difficult because the dependency is external?
- Does the business need a stable "charge payment" contract regardless of vendor count?

## A smaller design

A useful boundary may still be justified:

```text
CheckoutUseCase
→ PaymentGateway
    → VendorPaymentAdapter
```

Why?
- the vendor is an external failure boundary;
- vendor types should not define domain policy;
- tests can use a fake gateway;
- the abstraction expresses the application's required capability.

The factory/strategy/facade layers may add no value yet.

## When more abstraction becomes justified

Add structure when real pressure appears:
- several providers chosen by market/tenant;
- failover between providers;
- provider-specific capabilities;
- independent lifecycle/configuration;
- materially different settlement semantics.

## Wrong abstraction signals

- boolean flags such as useLegacyMode;
- methods only one implementation can support;
- vendor-specific types crossing the interface;
- callers using instanceof/type checks;
- every new requirement changes the abstraction and all implementations.

## Exercise

Design the smallest useful payment boundary today.

Then write the **trigger conditions** that would justify introducing a provider selection strategy later.

## Connections

[OCP](../02-solid/02-ocp.md) · [DIP](../02-solid/05-dip.md) · [Good Abstractions](../06-abstraction-encapsulation/01-abstraction-design.md) · [YAGNI](../03-simplicity/02-kiss-yagni-complexity-budget.md)
