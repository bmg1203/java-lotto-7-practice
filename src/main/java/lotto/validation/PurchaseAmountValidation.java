package lotto.validation;

import lotto.exception.InvalidPurchaseAmountException;

public final class PurchaseAmountValidation {

    public static int purchaseAmountValidationAndGetLottoQuantity(String purchaseAmountStr)
            throws IllegalArgumentException {
        InputValidation.isNotBlank(purchaseAmountStr);
        int purchaseAmount = InputValidation.parseNumberValidation(purchaseAmountStr);
        purchaseAmountValidation(purchaseAmount);
        return convertToLottoQuantity(purchaseAmount);
    }

    public static void purchaseAmountValidation(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }

    public static int convertToLottoQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}