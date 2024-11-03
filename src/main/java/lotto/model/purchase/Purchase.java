package lotto.model.purchase;

import static lotto.enums.LottoConstant.PRICE;

import java.util.List;
import lotto.model.draw.Payment;

public class Purchase {
    private final Payment payment;
    private final LottoTickets purchasedLottoTickets;

    public Purchase(final String payment) {
        this.payment = new Payment(payment);
        this.purchasedLottoTickets = new LottoTickets(calculateLottoCount());
    }

    public int calculateLottoCount() {
        return payment.getPayment() / PRICE;
    }

    public int getPayment() {
        return payment.getPayment();
    }

    public List<Lotto> getPurchasedLottoTickets() {
        return purchasedLottoTickets.getLottoTickets();
    }
}
