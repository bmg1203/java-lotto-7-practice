package lotto;

import java.util.List;

import static lotto.LottoConstants.*;

public class Lotto {
    private static final String COUNT_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(COUNT_ERROR);
        }

        if (numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
