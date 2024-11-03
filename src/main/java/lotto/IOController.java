package lotto;

import camp.nextstep.edu.missionutils.Console;

public class IOController {
    private static String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    Validator validator = new Validator();

    public String inputPurchaseAmount() {
        String purchaseAmountInput;
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        purchaseAmountInput = Console.readLine();
        return purchaseAmountInput;
    }

    public String inputWinningNumbers() {
        String winningNumbersInput;
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        winningNumbersInput = Console.readLine();
        return winningNumbersInput;
    }

    public String inputBonusNumber() {
        String bonusNumberInput;
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        bonusNumberInput = Console.readLine();
        return bonusNumberInput;
    }

    public void printLotto(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void printWinningStatistics(double statistic) {
        System.out.println("총 수익률은 " + statistic + "%입니다.");
    }
}
