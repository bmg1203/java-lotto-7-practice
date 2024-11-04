package view;

import constant.ErrorConst;
import utils.InputUtils;

public class InputViewImpl implements InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public long startView() {

        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String inputStringPrice = InputUtils.getInput();

        try {
            return Long.parseLong(inputStringPrice);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConst.ERROR_PARSING_NUMBER);
        }

    }


    public String inputWinningNumberView() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);

        String winningNumbersInput = InputUtils.getInput();
        String[] winningNumbers = winningNumbersInput.split(",", -1);

        validateWinningNumber(winningNumbers);
        return winningNumbersInput;
    }


    public String inputBonusNumberView() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumberInput = InputUtils.getInput();
        bonusNumberInput = InputUtils.deleteBlank(bonusNumberInput);
        return bonusNumberInput;
    }


    private void validateWinningNumber(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            winningNumber = InputUtils.deleteBlank(winningNumber);
            validateNumber(winningNumber);
        }
    }


    private void validateNumber(String winningNumber) {
        try {
            Integer.parseInt(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConst.ERROR_PARSING_NUMBER);
        }
    }
}
