package lotto.domain;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int REQUIRED_NUMBERS_COUNT = 6;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicates(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBERS_COUNT) {
            throw CustomIllegalArgumentException.from(INVALID_SIZE);
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw CustomIllegalArgumentException.from(DUPLICATE_NUMBER);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                throw CustomIllegalArgumentException.from(INVALID_NUMBER_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
