package dev.revision.checkout.solution;
import dev.revision.checkout.CheckoutModels.OrderRequest;
import dev.revision.checkout.CheckoutModels.Quote;
import org.springframework.stereotype.Component;
/** A concrete pure policy; there is no demonstrated need for a strategy interface. */
@Component
public class PricingPolicy {
    public Quote quote(OrderRequest request) {
        long subtotal = 0;
        for (var line : request.lines()) {
            subtotal = Math.addExact(subtotal,
                    Math.multiplyExact(line.unitPriceCents(), line.quantity()));
        }
        long discount = subtotal >= 10_000 ? subtotal / 10 : 0;
        return new Quote(subtotal, discount, Math.subtractExact(subtotal, discount));
    }
}
