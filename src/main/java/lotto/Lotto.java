package lotto;

import lotto.common.ExceptionMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ExceptionMessage.INVALID_COUNT_NUMBERS.getMessage());
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COUNT_NUMBERS.getMessage());
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            System.out.println(ExceptionMessage.NUMBER_DUPLICATED.getMessage());
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_DUPLICATED.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
