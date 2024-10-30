package lotto.lotodto;

import java.util.List;

public class InputDTO {
    private List<Integer> winningNumbers;

    private int bonusNumber;

    private List<Integer> AllNumbers;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAllNumbers() {
        return AllNumbers;
    }

    public void setAllNumbers(List<Integer> allNumbers) {
        AllNumbers = allNumbers;
    }
}
