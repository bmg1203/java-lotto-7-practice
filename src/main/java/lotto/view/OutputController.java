package lotto.view;

import lotto.service.InputService;

public class OutputController {
    public static void purchasePrint() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void lottoAmountPrint() {
        System.out.println(InputService.lottoAmount + "개를 구매했습니다.");
    }

    public static void winningNumPrint() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
