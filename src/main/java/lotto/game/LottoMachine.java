package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.LottoRules;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class LottoMachine {
    private final List<Lotto> generatedLottos = new ArrayList<>();

    public List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        int quantity = calculateTicketQuantity(purchaseAmount);

        for (int count = 0; count < quantity; count++) {
            generatedLottos.add(new Lotto(getRandomLottoNumbers()));
        }
        return generatedLottos;
    }

    private int calculateTicketQuantity(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / LottoRules.LOTTO_TICKET_PRICE;
    }

    private List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoRules.MIN_NUMBER, LottoRules.MAX_NUMBER,
                LottoRules.WINNING_NUMBERS_REQUIRED);
    }
}


