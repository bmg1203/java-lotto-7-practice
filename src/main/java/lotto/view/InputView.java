package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.exception.Exception.*;

public class InputView {
    public static int inputPurchaseAmount() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_INPUT_FOR_PURCHASE_AMOUNT.getMessage());
        }
    }
}
