package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return Integer.parseInt(purchaseAmount);
    }
}
