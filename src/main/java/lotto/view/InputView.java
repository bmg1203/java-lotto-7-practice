package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.utils.Parser;
import lotto.utils.Split;

public class InputView {

    public Purchase purchaseInput() {
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

    public Lotto winningNumberInput() {
        while(true) {
            try {
                String input = Console.readLine();
                return getLotto(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getLotto(String input) {
        List<String> winningNumberString = Split.commaSplit(input);
        List<Integer> winningNumber = Parser.parseStringListToIntList(winningNumberString);

        return new Lotto(winningNumber);
    }

    public Bonus bonusInput(Lotto winningNumber) {
        while(true) {
            try {
                String input = Console.readLine();
                int bonus = Parser.parseStringToInt(input);
                return new Bonus(winningNumber, bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
