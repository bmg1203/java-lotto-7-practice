package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();
        System.out.println();
        return amount;
    }

    public static String getWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String numbers = Console.readLine();
        System.out.println();
        return numbers;
    }

    public static String getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }
}
