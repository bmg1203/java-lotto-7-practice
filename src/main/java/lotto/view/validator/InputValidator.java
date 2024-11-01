package lotto.view.validator;

import static lotto.util.Splitter.DELIMITER;

import lotto.util.Convertor;

public class InputValidator {

    private static final String EMPTY_INPUT_ERROR_MESSAGE = "[ERROR] 공백은 입력할 수 없습니다.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String COMMA_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자 사이에 쉼표(,)를 사용해서 입력해주세요.";
    private static final String POSITIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 양수 정수만 입력해주세요.";

    public static void validateNull(final String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateInteger(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateContainsComma(final String input) {
        if(!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(COMMA_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateCommaFormat(final String input) {
        if(input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(COMMA_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validatePositiveNumber(final String input) {
        if(!(Convertor.stringToInt(input) > 0)) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
