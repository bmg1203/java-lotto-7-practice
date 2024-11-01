package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;
import lotto.enums.ErrorMessage;
import lotto.model.Lotto;
import lotto.utils.Utils;

public class LottoMachine {
    private List<Lotto> Tickets = new ArrayList<>();

    public List<Lotto> createLottoTicket(BigDecimal purchasePrice) {
        validatePurchasePrice(purchasePrice);
        int count = calculatorLottoCount(purchasePrice.intValue());

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(createRandomLottoNum());
            Tickets.add(lotto);
        }
        return Tickets;
    }

    private void validatePurchasePrice(BigDecimal purchasePrice) {
        if (!Utils.isInRange(new BigDecimal("1000"), new BigDecimal("100000"), purchasePrice)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
        if (!Utils.isDivisibleByThousand(purchasePrice.intValue())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }

    private List<Integer> createRandomLottoNum() {
        Set<Integer> randomNum = new HashSet<>();

        for (int i = 0; i < 6; i++) {
            if (!randomNum.add(Randoms.pickNumberInRange(1,45))) {
                i--;
            }
        }
        return randomNum.stream().toList();
    }

    private int calculatorLottoCount(int count) {
        return count / 1000;
    }
}