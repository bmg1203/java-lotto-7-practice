package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.util.Converter;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PriceValidator;
import lotto.validation.WinningNumberValidator;

public class InputView {

    public static PurchasePrice inputPurchasePrice() {
        String input = Console.readLine();
        PriceValidator.validatePrice(input);
        return new PurchasePrice(input);
    }

    public static WinningNumber inputWinningNumber() {
        String input = Console.readLine();
        WinningNumberValidator.validateWinningNumber(input);
        List<Integer> convertInput = Converter.convertStringToIntegerList(input);
        return new WinningNumber(convertInput);
    }

    public static BonusNumber inputBonusNumber(WinningNumber winningNumber) {
        String input = Console.readLine();
        BonusNumberValidator.validateBonusNumber(input);
        int convertInput = Converter.convertStringToInt(input);
        BonusNumberValidator.validateConvertBonusNumber(convertInput, winningNumber);
        return new BonusNumber(convertInput);
    }

}
