package lotto.model;

import java.util.HashSet;
import java.util.List;

import static lotto.constants.ErrorMessage.ERROR_DUPLICATE_NUMBERS;
import static lotto.constants.ErrorMessage.ERROR_NUMBER_SIZE;
import static lotto.constants.LottoConstants.COUNT;
import static lotto.constants.LottoConstants.FIVE;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(ERROR_NUMBER_SIZE);
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchingCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = getMatchingCount(winningNumbers);
        return matchingCount == FIVE && numbers.contains(bonusNumber);
    }
}
