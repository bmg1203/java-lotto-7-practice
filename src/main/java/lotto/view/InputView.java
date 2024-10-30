package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    private final static String LOTTO_PAY_MONEY = "구입금액을 입력해 주세요.";
    private final static String LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static void print(String message) {
        System.out.println(message);
    }

    public static void inputPrice() {
        print(LOTTO_PAY_MONEY);
    }

    public static void inputLottoNumber() {
        print(LOTTO_NUMBER);
    }

    public static void inputLottoBonus() {
        print(LOTTO_BONUS_NUMBER);
    }

}
