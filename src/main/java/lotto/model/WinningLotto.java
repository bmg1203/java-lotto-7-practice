package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumber(List<Integer> comparedNumbers) {
        int matchCount = 0;
        for (Integer number : comparedNumbers) {
            if (this.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
