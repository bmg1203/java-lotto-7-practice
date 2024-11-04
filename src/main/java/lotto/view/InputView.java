package lotto.view;

import static lotto.view.ViewMessageContainer.ENTER_BONUS_NUMBER;
import static lotto.view.ViewMessageContainer.ENTER_PURCHASE_AMOUNT;
import static lotto.view.ViewMessageContainer.ENTER_WINNING_LOTTO_NUMBERS;
import static lotto.view.ViewConstants.NEW_LINE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String requestWinningNumbers() {
        System.out.println(NEW_LINE + ENTER_WINNING_LOTTO_NUMBERS);
        return Console.readLine();
    }

    public String requestBonusNumber() {
        System.out.println(NEW_LINE + ENTER_BONUS_NUMBER);
        return Console.readLine();
    }
}