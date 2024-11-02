package exception;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        negativeValidate(numbers);
        duplicateValidate(numbers);
        rangeValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void negativeValidate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상이어야 합니다.");
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 45 이하이어야 합니다.");
        }
    }
}
