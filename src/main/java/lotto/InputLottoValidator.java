package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputLottoValidator {
    private static final String WINNING_NUMBER_REGEX_PATTERN = "\\d+";

    Lotto lotto;

    public void validateNumber(String winningNumber) {
        if (Pattern.matches(WINNING_NUMBER_REGEX_PATTERN, winningNumber)) {
            ErrorMessageUtil.WINNING_LOTTO_NOT_NUMBER_ERROR_MESSAGE.errorException();
        }
    }

    public List<Integer> getWinningNumber(String winningNumber) {
        validateNumber(winningNumber);
        checkEmpty(winningNumber);
        this.lotto = new Lotto(checkWrongSeparator(winningNumber));
        return checkWrongSeparator(winningNumber);
    }

    public List<Integer> checkWrongSeparator(String winningNumber){
        try {
            return Arrays.stream(winningNumber.split(",")).map(Integer::parseInt).toList();
        }catch (NumberFormatException e) {
            ErrorMessageUtil.WINNING_LOTTO_COMA_ERROR_MESSAGE.errorException();
        }
        return List.of();
    }

    public void checkEmpty(String winningNumber) {
        if (winningNumber.contains(" ")) {
            ErrorMessageUtil.WINNING_LOTTO_EMPTY_ERROR_MESSAGE.errorException();
        }
    }
}
