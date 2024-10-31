package lotto.domain;

import java.util.Objects;

public class Number {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final String errorMessage = "1 ~ 45 사이의 정수만 입력 가능합니다";

    private final int number;

    public Number(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public Number(String number) {
        int parsedNumber = parseStringToInteger(number);
        validateNumberRange(parsedNumber);
        this.number = parsedNumber;
    }

    public int value() {
        return number;
    }

    private int parseStringToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number numberObject)) return false;
        return number == numberObject.value();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
