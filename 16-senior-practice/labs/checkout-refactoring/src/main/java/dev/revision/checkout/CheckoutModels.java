package dev.revision.checkout;
import java.util.List;
import java.util.Objects;
public final class CheckoutModels {
    private CheckoutModels() {}
    public record OrderLine(String sku, long unitPriceCents, int quantity) {
        public OrderLine {
            if (sku == null || sku.isBlank()) throw new IllegalArgumentException("sku must not be blank");
            if (unitPriceCents < 0 || quantity <= 0)
                throw new IllegalArgumentException("price must be nonnegative and quantity positive");
        }
    }
    public record OrderRequest(String customerId, List<OrderLine> lines) {
        public OrderRequest {
            if (customerId == null || customerId.isBlank())
                throw new IllegalArgumentException("customerId must not be blank");
            Objects.requireNonNull(lines, "lines");
            lines = List.copyOf(lines);
            if (lines.isEmpty()) throw new IllegalArgumentException("order needs a line");
        }
    }
    public record Quote(long subtotalCents, long discountCents, long totalCents) {}
    public record Receipt(long orderId, long totalCents) {}
}
