package lotto.domain;

import static lotto.domain.constant.ErrorMessage.PRICE_UNMATCHED;

public class CashRegister {
    private int money;
    private final int SINGLE_LOTTO_PRICE = 1000;

    public CashRegister(int money) {
        validate(money);
        this.money = money;
    }


    private int calculateLottoCount() {
        return this.money / SINGLE_LOTTO_PRICE;
    }

    private void validate(int money) {
        if (money % SINGLE_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_UNMATCHED.getMessage());
        }
    }

}
