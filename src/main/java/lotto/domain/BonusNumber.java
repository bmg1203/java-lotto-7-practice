package lotto.domain;

import java.util.List;
import lotto.util.NumberValidator;

public class BonusNumber {

    private final int value;

    public BonusNumber(final int value) {
        validate(value);
        this.value = value;
    }

    public boolean isMatchNumber(List<Integer> numbers) {
        return numbers.contains(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(final int value) {
        final NumberValidator numberValidator = NumberValidator.getInstance();
        numberValidator.validateRange(value, 1, 45);
    }
}
