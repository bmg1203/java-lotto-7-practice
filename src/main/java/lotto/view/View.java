package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public String getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
    
}
