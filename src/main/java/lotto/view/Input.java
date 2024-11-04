package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.vo.BonusNumber;
import lotto.validator.InputValidator;
import lotto.vo.LottoNumber;
import lotto.vo.PurchaseAmount;
import lotto.vo.WinningNumber;

public class Input {
    public static PurchaseAmount getPurchaseAmount() {
        try {
            String input = Console.readLine();
            validateInput(input);
            return new PurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public static WinningNumber getWinningNumber() {
        try {
            String input = Console.readLine();
            validateInput(input);
            return new WinningNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    public static BonusNumber getBonusNumber(WinningNumber winningNumber) {
        try {
            String input = Console.readLine();
            validateInput(input);
            return new BonusNumber(new LottoNumber(input), winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumber);
        }
    }

    private static void validateInput(String input) {
        InputValidator.validateBlank(input);
        InputValidator.validateWhitespace(input);
    }
}
