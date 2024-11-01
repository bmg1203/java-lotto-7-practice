package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_DUPLICATED_NUMBERS;

public class Lotto {
    private static final String LINE_BREAK = "\n";
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> values = numbers.stream()
                .map(String::valueOf)
                .toList();

        stringBuilder.append("[");
        stringBuilder.append(String.join(", ", values));
        stringBuilder.append("]");
        stringBuilder.append(LINE_BREAK);

        return stringBuilder.toString();
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicatedNumbers(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() == LOTTO_NUMBER_COUNT) {
            return;
        }
        throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT);
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() == numbers.size()) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_DUPLICATED_NUMBERS);
    }

    public void calculateMatchingNumberCount(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int count = 0;
        boolean hasBonus = numbers.contains(bonusNumber.toInteger());
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        updateCountStatus(count, hasBonus);
    }

    private void updateCountStatus(int count, boolean hasBonus) {
        if (count == 3 && hasBonus == WinnerType.FIFTH.getBonusStatus()) {
            WinnerType.FIFTH.increaseCount();
        }

        if (count == 4 && hasBonus == WinnerType.FOURTH.getBonusStatus()) {
            WinnerType.FOURTH.increaseCount();
        }

        if (count == 5 && hasBonus == WinnerType.THIRD.getBonusStatus()) {
            WinnerType.THIRD.increaseCount();
        }

        if (count == 5 && hasBonus == WinnerType.SECOND.getBonusStatus()) {
            WinnerType.SECOND.increaseCount();
        }

        if (count == 6 && hasBonus == WinnerType.FIRST.getBonusStatus()) {
            WinnerType.FIRST.increaseCount();
        }
    }
}
