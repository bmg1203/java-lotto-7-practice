package lotto.validator;

import lotto.info.LottoInfo;
import lotto.message.ErrorMessage;

public class BonusNumberValidator {
    private static final String DEFAULT_ERROR_MESSAGE = "[ERROR] ";

    public static int validateBonusNumber(String input) {
        validateSingleNumber(input);
        int bonusNumber = parseAndValidateInteger(input);
        validatePositive(bonusNumber);
        validateRange(bonusNumber);
        return bonusNumber;
    }

    private static void validateSingleNumber(String input) {
        String[] tokens = input.split("[,\\s]+");
        if (tokens.length != 1) {
            throw new IllegalArgumentException(
                    DEFAULT_ERROR_MESSAGE + ErrorMessage.SINGLE_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private static int parseAndValidateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    DEFAULT_ERROR_MESSAGE + ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage(), e);
        }
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(
                    DEFAULT_ERROR_MESSAGE + ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateRange(int number) {
        if (number < LottoInfo.MIN_NUMBER.getNumber() || number > LottoInfo.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(
                    DEFAULT_ERROR_MESSAGE + ErrorMessage.OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
        }
    }
}
