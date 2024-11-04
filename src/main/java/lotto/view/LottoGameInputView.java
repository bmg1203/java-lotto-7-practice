package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameInputView {

    private LottoGameInputView() {
    }

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }


}
