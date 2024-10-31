package lotto.util;

import lotto.constant.ErrorMessage;
import lotto.constant.StringConstant;

import java.util.*;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.StringConstant.*;


public class Parser {

    public SequencedSet<Integer> ParseWinningNumber(String number) {
        SequencedSet<Integer> result = new LinkedHashSet<>();
        String[] numbers = number.split(NUMBER_DELIMITER);

        for (String num : numbers) {
            int value = stringToInt(num);
            result.add(value);
        }

        return result;
    }

    private static int stringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_FORMAT.getMessage(), e);
        }
    }
}
