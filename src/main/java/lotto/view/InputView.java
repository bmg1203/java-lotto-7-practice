package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.dto.WinningNumbersDto;
import lotto.view.validation.BonusNumberValidator;
import lotto.view.validation.PriceValidator;
import lotto.view.validation.WinningNumbersValidator;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static int inputPrice() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return PriceValidator.validate(Console.readLine());
    }

    public static List<Integer> winningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return WinningNumbersValidator.validate(Console.readLine());
    }

    public static int bonusNumber(WinningNumbersDto winningNumbersDto) {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return BonusNumberValidator.validate(winningNumbersDto, Console.readLine());
    }
}
