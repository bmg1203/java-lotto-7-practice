package lotto.model;

import java.util.List;

public class LottoManagementSystem {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoManagementSystem(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void recordRank(List<Integer> numbers){

    }

    private int returnRank(List<Integer> numbers) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return checkRank(numbers, matchCount);
    }

    private int checkRank(List<Integer> numbers, int matchCount) {
        if (matchCount == 6) {
            return 1;
        }

        if (matchCount == 5) {
            if (numbers.contains(bonusNumber)) {
                return 2;
            }
            return 3;
        }

        if (matchCount == 4) {
            return 4;
        }

        if (matchCount == 3) {
            return 5;
        }

        return 6;
    }

}
