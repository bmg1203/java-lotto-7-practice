package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.NumbersValidator;
import lotto.validator.PurchaseAmountValidator;

import static lotto.view.OutputView.*;

public class InputView {
    private final NumbersValidator numbersValidator = new NumbersValidator();

    public String getInput() {
        return Console.readLine();
    }

    public int getInputPurchaseAmount() {
        while (true) {
            promptPurchaseAmount();
            String purchaseAmountInput = getInput();
            try {
                return PurchaseAmountValidator.validateAndParse(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }

    public List<Integer> getInputWinningNumbers() {
        while (true) {
            promptWinningNumbers();
            String winningNumbersInput = getInput();
            try {
                numbersValidator.validateWinningNumbers(winningNumbersInput);
                return numbersValidator.getWinningNumbers();
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }

    public List<Integer> getInputBonusNumber() {
        while (true) {
            promptBonusNumber();
            String bonusNumberInput = getInput();
            try {
                numbersValidator.validateBonusNumber(bonusNumberInput);
                return numbersValidator.getBonusNumber();
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }
}
