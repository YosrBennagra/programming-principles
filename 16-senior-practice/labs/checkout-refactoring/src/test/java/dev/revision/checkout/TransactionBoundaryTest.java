package dev.revision.checkout;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import dev.revision.checkout.CheckoutModels.OrderLine;
import dev.revision.checkout.CheckoutModels.OrderRequest;
import dev.revision.checkout.solution.CheckoutService;
import dev.revision.checkout.solution.OrderWriter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
@SpringBootTest
@Import(TransactionBoundaryTest.FailingWriterConfig.class)
class TransactionBoundaryTest {
    @Autowired CheckoutService checkout;
    @Autowired JdbcTemplate jdbc;
    @BeforeEach
    void cleanDatabase() {
        jdbc.update("DELETE FROM outbox");
        jdbc.update("DELETE FROM orders");
    }
    @Test
    void rollbackIncludesSqlIssuedBeforeOutboxFailure() {
        var request = new OrderRequest("customer", List.of(new OrderLine("sku", 400, 2)));
        assertThatThrownBy(() -> checkout.place(request))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("simulated outbox failure");
        assertThat(jdbc.queryForObject("SELECT COUNT(*) FROM orders", Integer.class)).isZero();
        assertThat(jdbc.queryForObject("SELECT COUNT(*) FROM outbox", Integer.class)).isZero();
    }
    @TestConfiguration(proxyBeanMethods = false)
    static class FailingWriterConfig {
        @Bean @Primary
        OrderWriter failingWriter(JdbcTemplate jdbc) {
            return (customer, total) -> {
                jdbc.update("INSERT INTO orders (customer_id, total_cents) VALUES (?, ?)", customer, total);
                throw new IllegalStateException("simulated outbox failure");
            };
        }
    }
}
