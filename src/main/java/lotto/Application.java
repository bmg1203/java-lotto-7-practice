package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            try {
                InputView.requestAmount();
                int totalAmount = InputView.getAmount();
                List<Lotto> lotteries = LottoGenerator.generate(totalAmount);

                OutputView.printReceipt(new LottoReceipt(lotteries));

                InputView.requestWinningNumber();
                WinningNumber winningNumber = InputView.getWinningNumber();

                OutputView.printResult(winningNumber, lotteries, totalAmount);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
