package model;

import java.util.List;
import validation.Validation;

public class BonusNumber {

    private static final String WINNING_NUM_CONTAIN_BONUS_NUM_ERROR = "[ERROR] 당첨번호에 보너스 숫자가 존재합니다";
    private final int bonusNum;

    public BonusNumber(WinningLottoNum winningLottoNum, String input) {
        List<Integer> winningNums = winningLottoNum.getWinningNums();
        validate(winningNums, input);
        bonusNum = Integer.parseInt(input);
    }

    private void validate(List<Integer> nums, String input) {
        Validation.blankInput(input);
        Validation.numberInput(input);
        int num = Integer.parseInt(input);
        Validation.range(num);
        if (nums.contains(num)) {
            throw new IllegalArgumentException(WINNING_NUM_CONTAIN_BONUS_NUM_ERROR);
        }
    }

    public int get() {
        return bonusNum;
    }
}
