package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LINE_BREAK = "\n";

    public static String readBudget() {
        System.out.println(INPUT_BUDGET_MESSAGE);
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        System.out.println(LINE_BREAK + INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }
}
