package lotto.utils;

import static lotto.global.ErrorMessages.*;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static final String WINNING_NUM_PATTERN = "^(\\d+,)+\\d+$";

    public static void priceValidator(String input) {
        nullAndEmptyValidator(input);

        int price;

        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PRICE_FORMAT.toString());
        }

        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE_FORMAT_NEGATIVE.toString());
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_FORMAT_UNIT.toString());
        }
    }

    public static void winningNumValidator(String input) {
        nullAndEmptyValidator(input);

        if (!WINNING_NUM_PATTERN.matches(input)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_PATTERN.toString());
        }

        List<String> numbers = Arrays.asList(input.split(","));
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUM_COUNT.toString());
        }

        for (String number : numbers) {
            lottoNumValidator(number);
        }
    }

    public static void lottoNumValidator(String input) {
        nullAndEmptyValidator(input);

        int price;

        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT.toString());
        }

        if (price <= 0 || 46 <= price) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.toString());
        }
    }

    private static void nullAndEmptyValidator(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_NULL.toString());
        }
    }
}
