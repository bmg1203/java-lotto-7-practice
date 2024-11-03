package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.InputValidator;

public class InputView implements InputViewInterface{

    @Override
    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return  Console.readLine();
    }

    @Override
    public String readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

}
