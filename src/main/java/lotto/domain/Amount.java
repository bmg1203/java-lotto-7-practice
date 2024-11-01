package lotto.domain;

import static lotto.controller.LottoMachine.LOTTO_PRICE;

public class Amount {

    public static final String AMOUNT_ERROR_MSG = "[ERROR] 구입 금액은 1000(원) 단위의 숫자입니다. 예: 14000";

    private final int value;

    public Amount(int value) {
        validate(value);
        this.value = value;
    }

    public static Amount parseAmount(String input) {
        try {
            return new Amount(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }
    }

    private void validate(int value) {

        if (value <= 0 || value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }
    }

    public int getValue() {
        return value;
    }
}
