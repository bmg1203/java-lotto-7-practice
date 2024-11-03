package lotto.utils;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

public class BonusNumberInputParser {

    public static int parse(String input) {
        return convertToInteger(input);
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw CustomIllegalArgumentException.from(NOT_INTEGER);
        }
    }
}
