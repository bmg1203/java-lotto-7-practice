package lotto.domain;

import lotto.constants.ErrorMessage;

public class Purchase {

    private static final int MIN_MONEY = 1000;
    private static final int DIVIDE_RESULT = 0;
    private final int money;

    public Purchase(int money) {
        validateMin(money);
        validateDivide(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateMin(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MIN_MONEY_ERROR.getMessage());
        }
    }

    private void validateDivide(int money) {
        if (money % MIN_MONEY != DIVIDE_RESULT) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MONEY_ERROR.getMessage());
        }
    }
}
