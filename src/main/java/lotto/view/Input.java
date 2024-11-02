package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.BuyLottoValidate;

public class Input {

    public static int InputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return BuyLottoValidate.lottoBuyValidation(Console.readLine());
    }

    public static String InputWinNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String InputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
