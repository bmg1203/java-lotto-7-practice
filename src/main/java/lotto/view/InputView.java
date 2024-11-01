package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements ViewManager{

    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호 입력해 주세요.";

    protected String inputBuyAmount() {
        printMessage(INPUT_BUY_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    protected String inputWinningNumber() {
        printMessage(INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    protected String inputBonusNumber() {
        printMessage(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
