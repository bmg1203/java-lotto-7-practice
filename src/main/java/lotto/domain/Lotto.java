package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Constant;
import lotto.exception.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(String input) {
        validateBlank(input);
        String[] numbers = getNumbers(input);
        Arrays.stream(numbers).forEach(Lotto::validateNumeric);
        return new Lotto(Arrays.stream(numbers)
                .map(Lotto::parseInt)
                .collect(Collectors.toList()));
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_WINNING_NUMBER.getMessage());
        }
    }

    private static void validateNumeric(String input) {
        if (!input.matches(Constant.NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_LOTTO_NUMBER.getMessage());
        }
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TOO_BIG_LOTTO_NUMBER.getMessage());
        }
    }

    private static String[] getNumbers(String input) {
        return Arrays.stream(input.split(Constant.DELIMITER))
                .map(String::strip)
                .toArray(String[]::new);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        numbers.forEach(this::validateRange);
        validateDuplicate(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER_COUNT_SIX.getMessage());
        }
    }

    private void validateRange(Integer number) {
        if (number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
