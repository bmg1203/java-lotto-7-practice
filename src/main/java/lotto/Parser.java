package lotto;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String DELIMITER = ",";

    public static Purchase parsePurchase(String input) {
        int number = Parser.parseNumber(input);
        return new Purchase(number);
    }

    public static Lotto parseLottoNumber(String input) {
        List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                .map(Parser::parseNumber)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
