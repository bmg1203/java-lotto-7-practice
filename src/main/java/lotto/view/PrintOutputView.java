package lotto.view;

import static lotto.constant.PrintFormattedText.PURCHASE_RESULT;
import static lotto.constant.PrintText.REQUIRE_BONUS_NUMBER;
import static lotto.constant.PrintText.REQUIRE_PURCHASE_AMOUNT;
import static lotto.constant.PrintText.REQUIRE_WINNING_NUMBERS;

public class PrintOutputView {
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void printRequirePurchaseAmount() {
        System.out.println(REQUIRE_PURCHASE_AMOUNT.getText());
    }

    public void printRequireWinningNumbers() {
        System.out.println();
        System.out.println(REQUIRE_WINNING_NUMBERS.getText());
    }

    public void printRequireBonusNumber() {
        System.out.println();
        System.out.println(REQUIRE_BONUS_NUMBER.getText());
    }

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.println();
        System.out.println(PURCHASE_RESULT.format(purchaseAmount));
    }

    public void printRandomLottoNumbers(String randomLottos) {
        System.out.println(randomLottos);
    }
}
