package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static List<Integer> winningNumParse(String rawNumbers) {
        String[] input = rawNumbers.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();

        for (String num : input) {
            numbers.add((Integer.parseInt(num)));
        }
        return numbers;
    }
}
