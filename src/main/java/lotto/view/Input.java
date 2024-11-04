package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String pay() {
        System.out.println("구입금액을 입력해 주세요.");
        return getInputValue();
    }

    public String winningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return getInputValue();
    }

    public String bonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return getInputValue();
    }

    private String getInputValue() {
        return Console.readLine();
    }
}
