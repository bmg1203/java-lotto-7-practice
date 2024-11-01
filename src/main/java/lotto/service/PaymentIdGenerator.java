package lotto.service;

import java.util.concurrent.atomic.AtomicLong;

public class PaymentIdGenerator implements IdGenerator {

    private final AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Long generate() {
        return sequence.incrementAndGet();
    }
}
