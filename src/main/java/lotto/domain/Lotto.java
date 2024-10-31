package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Error;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_SIZE_ERROR.message());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(Error.LOTTO_DUPLICATE_ERROR.message());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Error.LOTTO_RANGE_ERROR.message());
            }
        }
    }

}