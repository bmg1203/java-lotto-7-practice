package lotto.domain;

import static lotto.constant.ErrorMessage.DUPLICATION_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_COUNT_ERROR;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplication(numbers);
        sortLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
