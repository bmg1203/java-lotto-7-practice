package lotto.presentation.view;

import java.util.regex.Pattern;

public final class InputPattern {

    private static final Pattern PURCHASE_AMOUNT = Pattern.compile("^\\d+원?$|^\\d{1,3}(,\\d{3})*원?$");
    private static final Pattern WINNING_NUMBERS = Pattern.compile("^(\\d+,\\s?)+\\d+$");
    private static final Pattern BONUS_NUMBER = Pattern.compile("\\d+");

    private InputPattern() {}

    public static boolean isInvalidPurchaseAmount(final String input) {
        return !PURCHASE_AMOUNT.matcher(input)
                .matches();
    }

    public static boolean isInvalidWinningNumbers(final String input) {
        return !WINNING_NUMBERS.matcher(input)
                .matches();
    }

    public static boolean isInvalidBonusNumber(final String input) {
        return !BONUS_NUMBER.matcher(input)
                .matches();
    }

}
