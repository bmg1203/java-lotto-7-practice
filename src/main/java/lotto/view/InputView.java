package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PRINT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int printGetPurchasePrice() {
        System.out.println(PRINT_PURCHASE_PRICE);
        return Integer.parseInt(Console.readLine());
    }

    public String printGetWinningLottoNumber() {
        System.out.println(PRINT_WINNING_NUMBER);
        return Console.readLine();
    }

    public int printGetBonusNumber() {
        System.out.println(PRINT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
