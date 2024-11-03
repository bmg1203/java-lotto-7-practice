package lotto.utils;

import static lotto.global.error.InputErrorMessages.*;
import static lotto.view.OutputView.LOTTO_NUMBER_DELIMITER;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static final String WINNING_NUM_PATTERN = "^(\\d+,)+\\d+$";
    public static final int MINIMAL_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int MINIMAL_PRICE_INPUT = 0;
    public static void priceValidator(String input) {
        nullAndEmptyValidator(input);

        int price;

        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PRICE_FORMAT.getMessage());
        }

        if (price <= MINIMAL_PRICE_INPUT) {
            throw new IllegalArgumentException(INVALID_PRICE_FORMAT_NEGATIVE.getMessage());
        }

        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_FORMAT_UNIT.getMessage());
        }
    }

    public static void winningNumValidator(String input) {
        nullAndEmptyValidator(input);

        if (!input.matches(WINNING_NUM_PATTERN)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_PATTERN.getMessage());
        }

        List<String> numbers = Arrays.asList(input.split(LOTTO_NUMBER_DELIMITER));
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUM_COUNT.getMessage());
        }

        for (String number : numbers) {
            lottoNumValidator(number);
        }
    }

    public static void lottoNumValidator(String input) {
        nullAndEmptyValidator(input);

        int lottoNumber;

        try {
            lottoNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT.getMessage());
        }

        if (lottoNumber < MINIMAL_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static void nullAndEmptyValidator(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_NULL.getMessage());
        }
    }
}
