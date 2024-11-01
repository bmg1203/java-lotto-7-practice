package lotto.validator;

import java.util.Arrays;

public class WinningNumbersInputValidator implements BasicValidator<String> {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final String COMMA = ",";
    private static final String INPUT_NOT_NUMERIC = "[ERROR] 입력값이 숫자가 아닙니다.";
    private static final String INPUT_NOT_SIX_NUMBERS = "[ERROR] 입력값이 6자리가 아닙니다.";
    private static final String INPUT_NOT_BETWEEN_ONE_AND_FORTY_FIVE = "[ERROR] 입력값이 1과 45 사이여야 합니다.";
    private static final String INPUT_DUPLICATED = "[ERROR] 입력값들이 중복되지 않아야 합니다.";

    @Override
    public void validate(String input) {
        validateAllNumbersIfNumeric(input);
        validateInputNumbersCount(input);
        validateNumbersRange(input);
        validateDuplicatedNumber(input);
    }

    private void validateAllNumbersIfNumeric(String input) {
        String[] numbers = input.split(COMMA);
        for (String number : numbers) {
            validateNumberIfNumeric(number);
        }
    }

    private void validateNumberIfNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMERIC);
        }
    }

    private void validateInputNumbersCount(String input) {
        String[] numbers = input.split(COMMA);
        if (numbers.length != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INPUT_NOT_SIX_NUMBERS);
        }
    }

    private void validateNumbersRange(String input) {
        String[] numbers = input.split(COMMA);
        for (String number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INPUT_NOT_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    private void validateDuplicatedNumber(String input) {
        String[] numbers = input.split(COMMA);
        if (Arrays.stream(numbers).distinct().count() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INPUT_DUPLICATED);
        }
    }
}