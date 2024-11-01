package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final String LOTTO_NUMBER_ERROR_MSG = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자입니다.";
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber parseLottoNumber(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MSG);
        }

        return new LottoNumber(number);
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MSG);
        }
    }

    public int getNumber() {
        return number;
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
        return Objects.hashCode(number);
    }
}
