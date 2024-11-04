package lotto.model.domain;

import static lotto.constant.ErrorMessages.INVALID_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.MIN_LOTTO_NUMBER;

import java.util.Objects;

public class LottoNumber {

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
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
