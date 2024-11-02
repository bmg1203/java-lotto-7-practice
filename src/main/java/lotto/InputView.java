package lotto;

import static lotto.MessageContainer.ENTER_PURCHASE_AMOUNT;
import static lotto.MessageContainer.ENTER_WINNING_LOTTO_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String requestWinningLottoNumbers() {
        System.out.println(ENTER_WINNING_LOTTO_NUMBERS);
        return Console.readLine();
    }
}
