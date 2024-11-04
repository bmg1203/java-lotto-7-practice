package lotto.utils.parser;

import static lotto.exception.ErrorMessage.*;

public class PurchaseTotalPriceParser {

    public static int parse(String input) {
        return convertToInteger(input);
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }
}
