package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Purchase;
import lotto.utils.Parser;

public class InputView {

    public static Purchase purchaseInput() {
        while(true) {
            try {
                String input = Console.readLine();
                int purchase = Parser.parseStringToInt(input);
                return new Purchase(purchase);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
