package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.OutputView.*;

public class InputView {

    public static String inputPurchaseAmount() {
        printInputPurchaseAmount();
        return Console.readLine();
    }
}
