package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.model.LottoConstants.LOTTO_LENGTH;

public class Validation {
    private static final String DUPLICATION_LIST_ERROR = "[ERROR] 입력 값들은 서로 중복되지 않아야 합니다.\n";
    private static final String LENGTH_ERROR = "[ERROR] 입력 값의 개수는 %d개 여야 합니다.\n";
    private static final String NUMBER_IN_RANGE_ERROR = "[ERROR] 입력 값의 범위는 %d부터 %d 사이의 숫자여야 합니다.\n";
    private static final String STRING_TO_INTEGER_ERROR = "[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.\n";
    private static final String MULTIPLE_NUMBER_ERROR = "[ERROR] 입력 값은 %d의 배수여야 합니다.\n";
    private static final int LEAST_PAY_AMOUNT = 1_000;

    public static void validateStringToInteger(String string) {
        if ( string.isBlank() || !string.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(STRING_TO_INTEGER_ERROR);
        }
    }

    public static void validateMultipleNumber(int dividend, int divisor) {
        if (dividend < divisor || dividend % divisor != 0) {
            throw new IllegalArgumentException(String.format(MULTIPLE_NUMBER_ERROR, divisor));
        }
    }

    public static void validatePayAmount(int amount) {
        validateMultipleNumber(amount, LEAST_PAY_AMOUNT);
    }

    public static void validateStringToListInteger(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException(STRING_TO_INTEGER_ERROR);
        }
        List<String> list = Arrays.asList(string.split(","));
        for (String str : list) {
            validateStringToInteger(str);
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        for (int number : numbers) {
            validateNumberInRange(number, startInclusive, endInclusive);
        }
    }

    public static void validateNumberInRange(int number, int startInclusive, int endInclusive) {
        if (number < startInclusive || number > endInclusive) {
            throw new IllegalArgumentException(String.format(NUMBER_IN_RANGE_ERROR,startInclusive, endInclusive));
        }
    }

    public static void validateListSize(List<Integer> list) {
        if (list.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(String.format(LENGTH_ERROR, LOTTO_LENGTH));
        }
    }

    public static void validateDuplicate(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            throw new IllegalArgumentException(DUPLICATION_LIST_ERROR);
        }
    }
}
