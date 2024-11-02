package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.PurchaseTotalPriceInput;

public class InputView {

    public PurchaseTotalPriceInput readPurchaseAmount() {
        String input = Console.readLine();
        return new PurchaseTotalPriceInput(input.trim());
    }
}
