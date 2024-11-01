package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicates(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 값이어야 합니다.");
            }
        }
    }

    public int getRank(List<Integer> winningNumbers, int bonusNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.)
        }

        int matchingCount = 0;
        for (int number : winningNumbers) {
            if (this.numbers.contains(number)) {
                matchingCount++;
            }
        }
        if (matchingCount == 5 && this.numbers.contains(bonusNumber)) {
            return 7;
        }
        return matchingCount;
    }
    // TODO: 추가 기능 구현
}
