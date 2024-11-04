package lotto.model;

import lotto.utility.ExceptionEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final int REQUIRED_NUMBERS_LENGTH = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
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
            System.out.println(ExceptionEnum.CANNOT_DRAW_DUPLICATE_NUMBER.getMessage());
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_DRAW_DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateLength(List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != REQUIRED_NUMBERS_LENGTH) {
            System.out.println(ExceptionEnum.MUST_SIX.getMessage());
            throw new IllegalArgumentException(ExceptionEnum.MUST_SIX.getMessage());
        }
    }

    private void validateOverFourtySix(List<Integer> parsedNumbers) {
        if (parsedNumbers.stream().anyMatch(number -> number > MAX_LOTTO_NUMBER)) {
            System.out.println(ExceptionEnum.CANNOT_OVER_FOURTY_SIX.getMessage());
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_OVER_FOURTY_SIX.getMessage());
        }
    }

    public void checkBonusDuplicate(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            System.out.println(ExceptionEnum.DUPLICATE_WINNING_AND_BONUS.getMessage());
            throw new IllegalArgumentException(ExceptionEnum.DUPLICATE_WINNING_AND_BONUS.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
