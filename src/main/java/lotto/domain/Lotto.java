package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.util.enums.ValidateMessage;

public class Lotto {
    private static final int FORTY_FIVE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
        validateOverThanFortyFive(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ValidateMessage.NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        Set<Integer> distinctNumbers = Set.copyOf(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(ValidateMessage.DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateOverThanFortyFive(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number > FORTY_FIVE) {
                throw new IllegalArgumentException(ValidateMessage.NUMBER_RANGE_ERROR.getMessage());
            }
        });
    }
}
