package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.message.PromptMessage;

public class InputView {
    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public String readPurchaseAmount() {
        System.out.println(PromptMessage.PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }
}
