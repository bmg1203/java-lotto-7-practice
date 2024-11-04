package lotto.domain;

import java.math.BigInteger;

import static lotto.exception.ExceptionCode.BUDGET_TOO_SMALL;
import static lotto.exception.ExceptionCode.REMAINDER_EXISTED;

public class Budget {

    public static final BigInteger LOTTO_PRICE = new BigInteger("1000");

    private final BigInteger value;
    private final BigInteger numberOfLotto;

    public Budget(BigInteger value) {
        validate(value);
        this.value = value;
        this.numberOfLotto = value.divide(LOTTO_PRICE);
    }

    private void validate(BigInteger value) {
        if (value.compareTo(LOTTO_PRICE) < 0) {
            throw new IllegalArgumentException(BUDGET_TOO_SMALL.message());
        }

        if (!value.remainder(LOTTO_PRICE).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException(REMAINDER_EXISTED.message());
        }
    }

    public BigInteger numberOfLotto() {
        return this.numberOfLotto;
    }

    public BigInteger value() {
        return value;
    }
}
