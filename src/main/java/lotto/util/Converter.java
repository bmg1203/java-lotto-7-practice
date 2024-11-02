package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static long convertStringToLong(String input) {
        return Long.parseLong(input.trim());
    }

    public static List<Integer> convertStringToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
