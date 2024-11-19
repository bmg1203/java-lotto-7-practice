package lotto.constants;

public enum LottoNumbers {

    LOTTO_MIN_RANGE(1),
    LOTTO_MAX_RANGE(45),
    LOTTO_LENGTH(6);

    private final int number;

    LottoNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
