package lotto.validation;

import lotto.enums.ErrorMessage;
import lotto.util.Converter;

public class PriceValidator {

    public static void validatePrice(String input) {
        validateNull(input);
        validateOnlyNumbers(input);
        long convertInput = Converter.convertStringToLong(input);
        validateZero(convertInput);
        validateUnderThousand(convertInput);
        validateDivideThousand(convertInput);
    }

    private static void validateNull(String price) {
        if (isNullOrEmpty(price)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateZero(long price) {
        if (price == 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ZERO.getErrorMessage());
        }
    }

    private static void validateUnderThousand(long price) {
        if (price < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_UNDER_THOUSAND.getErrorMessage());
        }
    }

    private static void validateDivideThousand(long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_NOT_DIVIDE_THOUSAND.getErrorMessage());
        }
    }

    private static void validateOnlyNumbers(String price) {
        if (!price.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_WITHOUT_NUMBER.getErrorMessage());
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
