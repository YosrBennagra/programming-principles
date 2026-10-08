package dev.revision.checkout;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import dev.revision.checkout.CheckoutModels.OrderLine;
import dev.revision.checkout.CheckoutModels.OrderRequest;
import dev.revision.checkout.legacy.LegacyCheckout;
import dev.revision.checkout.solution.CheckoutService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
@SpringBootTest
class CheckoutRegressionTest {
    @Autowired LegacyCheckout legacy;
    @Autowired CheckoutService checkout;
    @Autowired JdbcTemplate jdbc;
    @BeforeEach
    void cleanDatabase() {
        jdbc.update("DELETE FROM outbox");
        jdbc.update("DELETE FROM orders");
    }
    @ParameterizedTest
    @CsvSource({"1000, 2, 2000", "5000, 2, 9000", "9999, 1, 9999",
                "10000, 1, 9000", "10001, 1, 9001"})
    void refactorPreservesTotalsAndOutbox(long unitPrice, int quantity, long expected) {
        var request = new OrderRequest("customer-1", List.of(new OrderLine("sku", unitPrice, quantity)));
        var original = legacy.place(request);
        var revised = checkout.place(request);
        assertThat(original.totalCents()).isEqualTo(expected);
        assertThat(revised.totalCents()).isEqualTo(expected);
        assertThat(original.orderId()).isNotEqualTo(revised.orderId());
        assertThat(jdbc.queryForObject("SELECT COUNT(*) FROM orders", Integer.class)).isEqualTo(2);
        assertThat(jdbc.queryForObject("SELECT COUNT(*) FROM outbox", Integer.class)).isEqualTo(2);
        assertThat(jdbc.queryForObject(
                "SELECT COUNT(*) FROM outbox WHERE event_type = 'ORDER_PLACED'",
                Integer.class)).isEqualTo(2);
    }
    @Test
    void badDataAndOverflowDoNotPersist() {
        assertThatThrownBy(() -> new OrderLine("a", -1, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new OrderRequest(" ", List.of(new OrderLine("a", 1, 1))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new OrderRequest("ok", List.of()))
                .isInstanceOf(IllegalArgumentException.class);
        var overflow = new OrderRequest("ok", List.of(new OrderLine("a", Long.MAX_VALUE, 2)));
        assertThatThrownBy(() -> checkout.place(overflow)).isInstanceOf(ArithmeticException.class);
        assertThat(jdbc.queryForObject("SELECT COUNT(*) FROM orders", Integer.class)).isZero();
        assertThat(jdbc.queryForObject("SELECT COUNT(*) FROM outbox", Integer.class)).isZero();
    }
    @Test
    void requestDefensivelyCopiesLines() {
        var lines = new java.util.ArrayList<>(List.of(new OrderLine("a", 100, 1)));
        var request = new OrderRequest("ok", lines);
        lines.clear();
        assertThat(request.lines()).hasSize(1);
        assertThatThrownBy(() -> request.lines().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
