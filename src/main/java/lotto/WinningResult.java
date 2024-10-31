package lotto;

import java.util.List;

public class WinningResult {

    public int countMatch(WinnerNumbers winnerNumbers, Lotto lotto) {
        int count = 0;
        List<Integer> winningNumbers = winnerNumbers.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        for (Integer winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }
}
