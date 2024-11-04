package lotto.handler;

import static lotto.message.OutputMessage.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.message.OutputMessage.PURCHASE_AMOUNT_INPUT_MESSAGE;
import static lotto.message.OutputMessage.WINNING_NUMBERS_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;

public class InputHandler {
    public int readPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return PurchaseAmountValidator.validatePurchaseAmount(input);
    }

    public List<Integer> readWinningNumbersInput() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return WinningLottoValidator.validateWinningNumbers(input);
    }

    public int readBonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return WinningLottoValidator.validateBonusNumber(input);
    }
}
