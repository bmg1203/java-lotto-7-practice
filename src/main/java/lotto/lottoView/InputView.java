package lotto.lottoView;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_MESSAGE = "구입금액을 입력해주세요.";
    private static final String HIT_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_LOTTO_MESSAGE = "보너스 번호를 입력해 주세요.";


    public String readInput() {
        return Console.readLine();
    }

    public void PrintStartMsg() {
        System.out.println(START_MESSAGE);
        readInput();
    }

    public void PrintLottoInputMsg() {
        System.out.println(HIT_LOTTO_MESSAGE);
        readInput();
    }

    public void PrintBonusLottoInputMsg() {
        System.out.println(BONUS_LOTTO_MESSAGE);
        readInput();
    }
}
