package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.Validator;

public class InputView {
    public int inputLottoAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        return Validator.validateLottoAmount(amount);
    }

    public List<Integer> inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        return Validator.validateWinningLotto(winningNumber);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return Validator.validateBonusNumber(bonusNumber);
    }
}
