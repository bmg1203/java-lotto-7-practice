package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorMessage;

public class Parser {

    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_ERROR.getMessage());
        }
    }

    public static List<Integer> parseStringListToIntList(List<String> inputs) {
        try {
            List<Integer> numbers = new ArrayList<>();
            for (String input : inputs) {
                numbers.add(Integer.parseInt(input));
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_ERROR.getMessage());
        }
    }
}
