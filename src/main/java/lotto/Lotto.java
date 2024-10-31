package lotto;

import static lotto.model.LottoRule.MAX_NUMBER;
import static lotto.model.LottoRule.MIN_NUMBER;
import static lotto.model.LottoRule.NUMBER_COUNT;

import java.util.List;
import lotto.exception.DuplicateNumberException;
import lotto.exception.OverRangeException;

public class Lotto {
    private static final String INVALID_COUNT_MESSAGE = "[ERROR] 로또 번호는 6개이어야 합니다.";
    private static final String OVER_RANGE_MESSAGE = "[ERROR] 로또 번호의 범위를 초과했습니다.";
    private static final String DUPLICATE_MESSAGE = "[ERROR] 중복된 로또 번호가 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT.getConstant()) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (distinctCount != NUMBER_COUNT.getConstant()) {
            throw new DuplicateNumberException(DUPLICATE_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER.getConstant() || number > MAX_NUMBER.getConstant())) {
            throw new OverRangeException(OVER_RANGE_MESSAGE);
        }
    }
}
