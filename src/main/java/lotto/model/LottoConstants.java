package lotto.model;

public enum LottoConstants {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_COUNT(6),
    LOTTO_PRICE(1000),
    ;

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
