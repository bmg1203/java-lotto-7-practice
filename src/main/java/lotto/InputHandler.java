package lotto;

import camp.nextstep.edu.missionutils.Console;

public final class InputHandler {

    public static int inputLottoPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            final int purchaseAmount = InputConverter.convertToPurchaseAmount(Console.readLine());
            InputValidator.validatePurchaseAmountIsZero(purchaseAmount);
            InputValidator.validatePurchaseAmountUnit(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        return 0;
    }
}
