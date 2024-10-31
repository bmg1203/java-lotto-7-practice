package lotto.value;

import java.math.BigInteger;
import java.util.Objects;

public class Won {

    private final BigInteger amount;

    private Won(BigInteger amount) {
        if (amount == null) {
            throw new IllegalArgumentException("[ERROR] null을 지정할 수 없습니다.");
        }
        if (isSmallerThanZero(amount)) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수일 수 없습니다.");
        }
        this.amount = amount;
    }

    private Won(Integer amount) {
        this(BigInteger.valueOf(amount));
    }

    public static Won of(Integer amount) {
        return new Won(amount);
    }

    private static boolean isSmallerThanZero(BigInteger amount) {
        return amount.compareTo(BigInteger.ZERO) < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Won other = (Won) o;
        return Objects.equals(amount, other.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

}
