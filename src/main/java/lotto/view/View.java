package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static void promptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static int inputLottoPurchaseAmount() {
        String amountInput = Console.readLine();
        return Integer.parseInt(amountInput);
    }




}
