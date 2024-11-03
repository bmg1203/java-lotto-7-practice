package controller;

import domain.Lotto;
import domain.PlayerBuyLotto;
import view.Input;
import view.Output;

import java.util.List;

public class RunApplication {

    public void run() {

        Input input = new Input();
        Output output = new Output();
        PlayerBuyLotto playerBuyLotto = new PlayerBuyLotto();

        while(true) {
            try {
                String purchaseAmount = input.inputPurchaseAmount();
                int lottoPurchased = playerBuyLotto.purchasedLottoNums(purchaseAmount);
                List<List<Integer>> Lottos = output.printPurchasedLotto(lottoPurchased);
                break;
//                String winningNumbers = input.inputWinningNumbers();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
