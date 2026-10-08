package dev.revision.checkout.legacy;
import dev.revision.checkout.CheckoutModels.OrderRequest;
import dev.revision.checkout.CheckoutModels.Receipt;
import java.sql.Statement;
import java.util.Objects;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/** Before: pricing, SQL, and orchestration are mixed together. */
@Service
public class LegacyCheckout {
    private final JdbcTemplate jdbc;
    public LegacyCheckout(JdbcTemplate jdbc) { this.jdbc = jdbc; }
    @Transactional
    public Receipt place(OrderRequest request) {
        long subtotal = 0;
        for (var line : request.lines()) {
            subtotal = Math.addExact(subtotal,
                    Math.multiplyExact(line.unitPriceCents(), line.quantity()));
        }
        long discount = subtotal >= 10_000 ? subtotal / 10 : 0;
        long total = Math.subtractExact(subtotal, discount);
        var keys = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            var statement = connection.prepareStatement(
                    "INSERT INTO orders (customer_id, total_cents) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, request.customerId());
            statement.setLong(2, total);
            return statement;
        }, keys);
        long orderId = Objects.requireNonNull(keys.getKey(), "missing order id").longValue();
        jdbc.update("INSERT INTO outbox (order_id, event_type) VALUES (?, ?)",
                orderId, "ORDER_PLACED");
        return new Receipt(orderId, total);
    }
}
