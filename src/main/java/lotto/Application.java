package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = promptForPurchaseAmount();
        WinningLotto winningLotto = promptForWinningLotto();
    }

    private static PurchaseAmount promptForPurchaseAmount() {
        try {
            int amount = Input.readPurchaseAmount();
            return new PurchaseAmount(amount);
        } catch (IllegalArgumentException e) {
            return promptForPurchaseAmount();
        }
    }

    private static WinningLotto promptForWinningLotto() {
        try {
            Lotto winningNumbers = Input.readWinningNumbers();
            int bonusNumber = Input.readBonusNumber();
            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            return promptForWinningLotto();
        }
    }
}
