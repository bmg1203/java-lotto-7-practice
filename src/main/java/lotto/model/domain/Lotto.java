package lotto.model.domain;

import static lotto.constant.LottoConstant.MAX_NUM;
import static lotto.constant.LottoConstant.MIN_NUM;
import static lotto.constant.LottoConstant.SIZE;
import static lotto.ui.error.LottoError.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Set<Integer> getTempSet() {
        return new HashSet<>(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_ERR);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isInRange = numbers
                .stream()
                .allMatch(num -> num >= MIN_NUM && num <= MAX_NUM);

        if (!isInRange) {
            throw new IllegalArgumentException(LOTTO_NUM_OUT_OF_RANGE_ERR);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numbersSet = Set.copyOf(numbers);
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERR);
        }
    }

    @Override
    public String toString() {
        return "[" +
                String.join(", ", numbers.stream().map(String::valueOf).toList()) +
                "]";
    }
}
