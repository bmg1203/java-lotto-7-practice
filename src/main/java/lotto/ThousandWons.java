package lotto;

import static lotto.util.StringConverter.toInt;

public class ThousandWons {

    private final int value;

    public ThousandWons(int value) {
        this.value = value;
    }

    public static ThousandWons of(String money) {
        validate(toInt(money));
        return ThousandWons.of(money);
    }

    public int getValue() {
        return value;
    }

    private static void validate(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력 가능 합니다.");
        }
    }
}

