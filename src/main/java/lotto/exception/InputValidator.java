package lotto.exception;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String BLANK = " ";
    private static final Pattern PURCHASE_AMOUNT_PATTERN = Pattern.compile("^[1-9][0-9]?000|100000$");
    private static final Pattern WINNING_NUMBERS_PATTERN = Pattern.compile("^([0-9]{1,2},){5}[0-9]{1,2}");

    public static void validateContainsBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_BLANK.getErrorMessage());
        }
    }

    public static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getErrorMessage());
        }
    }

    public static void validatePurchaseAmount(String purchaseAmount) {
        if (!PURCHASE_AMOUNT_PATTERN.matcher(purchaseAmount).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getErrorMessage());
        }
    }

    public static void validateWinningNumbers(String winningNumbers) {
        if (!WINNING_NUMBERS_PATTERN.matcher(winningNumbers).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getErrorMessage());
        }
    }
}
