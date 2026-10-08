package dev.revision.checkout.solution;
import dev.revision.checkout.CheckoutModels.OrderRequest;
import dev.revision.checkout.CheckoutModels.Receipt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/** After: cohesive orchestration, pure pricing and a meaningful infrastructure boundary. */
@Service
public class CheckoutService {
    private final PricingPolicy pricing;
    private final OrderWriter writer;
    public CheckoutService(PricingPolicy pricing, OrderWriter writer) {
        this.pricing = pricing;
        this.writer = writer;
    }
    @Transactional
    public Receipt place(OrderRequest request) {
        long total = pricing.quote(request).totalCents();
        long orderId = writer.saveWithOutbox(request.customerId(), total);
        return new Receipt(orderId, total);
    }
}
