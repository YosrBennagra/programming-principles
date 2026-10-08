package dev.revision.checkout;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import dev.revision.checkout.CheckoutModels.OrderLine;
import dev.revision.checkout.CheckoutModels.OrderRequest;
import dev.revision.checkout.solution.PricingPolicy;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
/** No Spring context is needed to test pure domain logic. */
class PricingPolicyTest {
    private final PricingPolicy policy = new PricingPolicy();

    @ParameterizedTest
    @CsvSource({"9999, 0, 9999", "10000, 1000, 9000", "10001, 1000, 9001"})
    void discountThreshold(long subtotal, long expectedDiscount, long expectedTotal) {
        var request = new OrderRequest("customer", List.of(new OrderLine("sku", subtotal, 1)));
        var result = policy.quote(request);
        assertThat(result.subtotalCents()).isEqualTo(subtotal);
        assertThat(result.discountCents()).isEqualTo(expectedDiscount);
        assertThat(result.totalCents()).isEqualTo(expectedTotal);
    }

    @Test
    void combinesSeveralOrderLines() {
        var request = new OrderRequest("customer",
                List.of(new OrderLine("a", 1000, 2), new OrderLine("b", 500, 4)));
        assertThat(policy.quote(request).totalCents()).isEqualTo(4000);
    }

    @Test
    void rejectsOverflowInsteadOfWrappingAround() {
        var request = new OrderRequest("customer",
                List.of(new OrderLine("a", Long.MAX_VALUE, 1), new OrderLine("b", 1, 1)));
        assertThatThrownBy(() -> policy.quote(request)).isInstanceOf(ArithmeticException.class);
    }
}
