package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int)numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean hasBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public String getNumbers() {
        return this.numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]"));
    }
}
