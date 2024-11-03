package lotto;

import java.util.List;
import java.util.regex.Pattern;

public class InputBonusValidator {
    private static final String BONUS_NUMBER_REGEX_PATTERN = "\\d+";

    String bonusNumber;

    public void validate() {

    }

    public InputBonusValidator(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber() {
        if (!Pattern.matches(BONUS_NUMBER_REGEX_PATTERN, bonusNumber)) {
            ErrorMessageUtil.BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE.errorException();
        }
    }

    public void checkSameNumberInWinningNumber(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            ErrorMessageUtil.BONUS_NUMBER_REPEAT_ERROR_MESSAGE.errorException();
        }
    }

    public void validateNumberRange() {
        if (Integer.parseInt(bonusNumber) > 45 || Integer.parseInt(bonusNumber) < 0) {
            ErrorMessageUtil.BONUS_NUMBER_RANGE_ERROR_MESSAGE.errorException();
        }
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        validateBonusNumber();
        checkSameNumberInWinningNumber(winningNumber,Integer.parseInt(bonusNumber));
        validateNumberRange();
        return Integer.parseInt(bonusNumber);
    }
}
