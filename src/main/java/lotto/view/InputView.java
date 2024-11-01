package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputValidator;

public class InputView {
    private final static String INPUT_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";

    public int getLottoAmount() {
        System.out.println(INPUT_MONEY_AMOUNT);
        String money = Console.readLine();

        InputValidator.validateMoney(money);

        return Integer.parseInt(money);
    }

    public List<Integer> getWinningLottoNumber() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER);
        String lottoNumber = Console.readLine();

        InputValidator.validateLottoNumber(lottoNumber);

        return InputValidator.makeLottoNumber(lottoNumber);
    }

    public int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();

        InputValidator.validateBonusNumber(bonusNumber);

        return Integer.parseInt(Console.readLine());
    }
}
