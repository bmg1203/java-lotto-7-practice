package lotto.view.domain;

import lotto.view.global.exception.CustomException;
import lotto.view.global.exception.ErrorMessage;

public class Amount {
    private static final int MINIMUM_AMOUNT = 1000;
    private static final int MAXIMUM_AMOUNT = 100000000;
    private Integer value;

    public Amount(Integer amount) {
        validateAmount(amount);
        this.value = amount;
    }

    public Integer getValue() {
        return value;
    }

    private void validateAmount(Integer amount) {
        validateDivisibleByThousand(amount);
        validateAmountRange(amount);
    }

    private void validateDivisibleByThousand(Integer amount) {
        if (amount % 1000 != 0) {
            throw CustomException.of(ErrorMessage.INVALID_AMOUNT_DIVISIBILITY);
        }
    }

    private void validateAmountRange(Integer amount) {
        if (amount < MINIMUM_AMOUNT || amount > MAXIMUM_AMOUNT) {
            throw CustomException.of(ErrorMessage.INVALID_INPUT_NUMBER);
        }
    }
}
