package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;
    private final List<Integer> allNumbers;

    private static final String WRONG_RANGE_NUMBER = "[ERROR] 범위에 맞는 숫자를 입력해주세요.";
    private static final String WRONG_INTEGER_NUMBER = "[ERROR] 정수를 입력해주세요.";
    private static final String WRONG_SIZE = "[ERROR] 숫자는 6개 입력해주세요.";
    private static final String DUPLICATE_NUMBER = "[ERROR] 중복되는 숫자가 있습니다.";

    public WinningNumber(String winningNumber, String bonusNumber) {
        this.winningNumbers = convertWinningNumbers(winningNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
        checkRange();
        checkSize();
        checkDuplicate();
        this.allNumbers = result();
    }

    private List<Integer> convertWinningNumbers(String winningNumber) {
        try {
            return Arrays.stream(
                    winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_INTEGER_NUMBER);
        }
    }

    private void checkRange() {
        for (int number : winningNumbers) {
            if (!(number > 0 && number <= 45)) {
                throw new IllegalArgumentException(WRONG_RANGE_NUMBER);
            }
        }
    }

    private void checkSize() {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(WRONG_SIZE);
        }
    }

    private void checkDuplicate() {
        List<Integer> allNumbers = new ArrayList<>(winningNumbers);
        allNumbers.add(bonusNumber.getBonusNumber());

        if (allNumbers.stream().distinct().count() != allNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    private List<Integer> result() {
        List<Integer> result = new ArrayList<>(winningNumbers);
        result.add(bonusNumber.getBonusNumber());

        return result;
    }

    public List<Integer> getAllNumbers() {
        return allNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
