package lotto.input.parser;

import lotto.exception.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public Integer parseInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER.getMessage());
        }
    }

    public List<Integer> parseIntList(String input) throws IllegalArgumentException {
        return splitByComma(input).stream()
                .map(this::parseInt)
                .collect(Collectors.toList());
    }


    private List<String> splitByComma(String input) {
            if (input.isEmpty()) {
                throw new IllegalArgumentException(ExceptionMessage.NO_SUCH_ELEMENT.getMessage());
            }
            return Arrays.asList(input.trim().split(","));
    }
}