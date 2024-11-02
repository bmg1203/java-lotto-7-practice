package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.util.Converter;
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
}
