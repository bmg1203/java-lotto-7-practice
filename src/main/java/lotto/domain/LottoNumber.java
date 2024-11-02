package lotto.domain;

import java.util.Objects;
import lotto.settings.LottoSettings;

public class LottoNumber {


    private final int number;

    public LottoNumber(int number) {
        if (inRange(number)) {
            throw new IllegalArgumentException("로또의 숫자는 1~45사이의 숫자이여야 합니다.");
        }
        this.number = number;
    }

    public LottoNumber(String value) {
        this(toInt(value));
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static boolean inRange(int number) {
        return number < LottoSettings.MIN_NUMBER.value() || LottoSettings.MAX_NUMBER.value() < number;
    }

    public int value() {
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
        return Objects.hash(number);
    }
}
