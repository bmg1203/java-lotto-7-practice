package lotto.model;

import static lotto.constants.LottoConfig.NUMBERS_SIZE;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MAXIMUM;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MINIMUM;

import java.util.List;
import java.util.Objects;
import lotto.constants.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (hasTooManyNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_TOO_MANY_NUMBERS.getMessage());
        }
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATE_NUMBER.getMessage());
        }
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private boolean hasTooManyNumbers(List<Integer> numbers) {
        return numbers.size() != NUMBERS_SIZE;
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return number < NUMBER_RANGE_MINIMUM || number > NUMBER_RANGE_MAXIMUM;
    }

    public boolean contains(BonusNumber bonusNumber) {
        int number = bonusNumber.getNumber();
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto lotto)) {
            return false;
        }
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
