package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String BUYING_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

	public String readMoney() {
		System.out.println(BUYING_MONEY_MESSAGE);

		return Console.readLine();
	}

	public String readWinningNumber() {
		System.out.println(WINNING_NUMBER_MESSAGE);

		return Console.readLine();
	}

	public String readBonusNumber() {
		System.out.println();
		System.out.println(BONUS_NUMBER_MESSAGE);

		return Console.readLine();
	}

}
