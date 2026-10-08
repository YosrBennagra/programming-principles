package dev.revision.checkout.solution;
import java.sql.Statement;
import java.util.Objects;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
@Repository
public class JdbcOrderWriter implements OrderWriter {
    private final JdbcTemplate jdbc;
    public JdbcOrderWriter(JdbcTemplate jdbc) { this.jdbc = jdbc; }
    @Override
    public long saveWithOutbox(String customerId, long totalCents) {
        var keys = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            var statement = connection.prepareStatement(
                    "INSERT INTO orders (customer_id, total_cents) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customerId);
            statement.setLong(2, totalCents);
            return statement;
        }, keys);
        long orderId = Objects.requireNonNull(keys.getKey(), "missing order id").longValue();
        jdbc.update("INSERT INTO outbox (order_id, event_type) VALUES (?, ?)",
                orderId, "ORDER_PLACED");
        return orderId;
    }
}
