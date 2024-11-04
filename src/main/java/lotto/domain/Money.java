package lotto.domain;

import lotto.exception.MoneyException;
import lotto.exception.MoneyExceptionType;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private void validateZero(int inputValue) {
        if (inputValue == ZERO) {
            throw new MoneyException(MoneyExceptionType.ZERO_MONEY);
        }
    }

    private void validateDivideMoney(int inputValue) {
        if (inputValue % THOUSAND != ZERO) {
            throw new MoneyException(MoneyExceptionType.NOT_UNIT_MONEY);
        }
    }

    public int getTicket() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}