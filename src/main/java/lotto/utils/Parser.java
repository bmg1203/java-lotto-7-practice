package lotto.utils;

import lotto.constants.ErrorMessage;

public class Parser {

    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_ERROR.getMessage());
        }
    }
}
