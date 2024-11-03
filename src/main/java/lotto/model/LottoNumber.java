package lotto.model;

import static lotto.constant.ErrorMessages.INVALID_LOTTO_NUMBER;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN_VALUE = 1;
    private static final int LOTTO_NUMBER_MAX_VALUE = 45;

    private final int number;

    public LottoNumber(String stringNumber) {
        int number = parsePositiveNumber(stringNumber);
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private int parsePositiveNumber(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }

        try {
            int intNumber = Integer.parseInt(number);
            if (intNumber <= 0) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
            }
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
    }

    private void validateRange(int number) {
        if (number < LOTTO_NUMBER_MIN_VALUE || number > LOTTO_NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
    }
}
