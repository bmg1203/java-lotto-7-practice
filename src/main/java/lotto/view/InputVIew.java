package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputVIew {
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String inputLottoNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumbers(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
