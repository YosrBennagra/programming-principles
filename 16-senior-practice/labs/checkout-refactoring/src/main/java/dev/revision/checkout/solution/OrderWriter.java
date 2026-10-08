package dev.revision.checkout.solution;
/** The persistence and outbox boundary; the use case owns its transaction. */
@FunctionalInterface
public interface OrderWriter {
    long saveWithOutbox(String customerId, long totalCents);
}
