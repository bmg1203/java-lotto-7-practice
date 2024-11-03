package lotto.model;

import lotto.utility.ExceptionEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateLength(winningNumbers);
        validateDuplicates(winningNumbers);
        validateOverFourtySix(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateDuplicates(List<Integer> parsedNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(parsedNumbers);
        if (uniqueNumbers.size() != parsedNumbers.size()) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_DRAW_DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateLength(List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionEnum.MUST_SIX.getMessage());
        }
    }

    private void validateOverFourtySix(List<Integer> parsedNumbers) {
        if (parsedNumbers.stream().anyMatch(number -> number >= 46)) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_OVER_FOURTY_SIX.getMessage());
        }
    }

    public void checkBonusDuplicate(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionEnum.DUPLICATE_WINNING_AND_BONUS.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
