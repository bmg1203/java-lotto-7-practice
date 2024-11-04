package lotto.validator;

import lotto.message.ErrorMessage;

public class LottoAmountValidator {
    public static int validatePurchaseAmount(String lottoAmount) {
        inputNullOrEmpty(lottoAmount);
        checkForBlankSpace(lottoAmount);
        int lottoRound = convertPurchaseAmountToInt(lottoAmount);
        validateAmountRange(lottoRound);
        validateAmountIncrement(lottoRound);
        return lottoRound / 1000;
    }

    private static void checkForBlankSpace(String lottoAmount) {
        if (lottoAmount.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_HAS_BLANK.getMessage());
        }
    }

    private static void validateAmountRange(int lottoRound) {
        if (lottoRound < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NEGATIVE_OR_ZERO.getMessage());
        }
    }

    private static void validateAmountIncrement(int lottoRound) {
        if (lottoRound % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static int convertPurchaseAmountToInt(String lottoAmount) {
        try {
            return Integer.parseInt(lottoAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER.getMessage());
        }
    }

    public static void inputNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL_OR_EMPTY.getMessage());
        }
    }
}
