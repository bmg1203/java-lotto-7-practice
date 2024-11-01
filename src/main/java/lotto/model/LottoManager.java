package lotto.model;

import java.util.List;

public class LottoManager {

    public static final int AMOUNT_UNIT = 1000;
    private final LottoMachine lottoMachine;

    public LottoManager(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> createLottoTickets(int amount) {
        int purchaseQuantity = amount / AMOUNT_UNIT;

        return lottoMachine.createLotto(purchaseQuantity);
    }

    public Lotto createWinningLottoTicket(List<Integer> numbers) {
        return lottoMachine.createWinningLotto(numbers);
    }
}