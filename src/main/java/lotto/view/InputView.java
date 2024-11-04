package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.StringParser;
import lotto.validation.Validation;

import java.util.List;


public class InputView {
    private static final String MONEY_INPUT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    private static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static String moneyInput() {
        return input(MONEY_INPUT);
    }

    private static String winningNumbersInput() {
        return input(WINNING_NUMBERS_INPUT);
    }

    private static String bonusNumberInput() {
        return input(BONUS_NUMBER_INPUT);
    }

    public static int getMoney() {
        while (true) {
            String inputMoney = InputView.moneyInput();
            try {
                return getValidMoney(inputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            String inputWinningNumbers = InputView.winningNumbersInput();
            try {
                return StringParser.parseStringToIntegerList(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Integer getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            String inputBonusNumber = InputView.bonusNumberInput();
            try {
                return getValidBonusNumber(winningNumbers, inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Integer getValidMoney(String inputMoney) {
        return StringParser.parseStringToInt(inputMoney);
    }

    private static Integer getValidBonusNumber(List<Integer> winningNumbers, String inputBonusNumber) {
        Integer bonusNumber = StringParser.parseStringToInt(inputBonusNumber);
        Validation.validateDuplicateNumbersWithBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
