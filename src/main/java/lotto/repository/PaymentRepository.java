package lotto.repository;

import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.payment.Payment;

public class PaymentRepository {
    private final ConcurrentHashMap repository = new ConcurrentHashMap<Long, Payment>();

    private PaymentRepository() {
    }

    public Long save(Payment payment) {
        repository.put(payment.getId(), payment);
        return payment.getId();
    }
}
