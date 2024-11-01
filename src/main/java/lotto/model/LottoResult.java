package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoResult(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않습니다.");
        }
    }

    public Map<Score, Integer> calculateResults(LottoList lottoList) {
        Map<Score, Integer> resultCount = new HashMap<>();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        for (Lotto lotto : lottoList.getLottoList()) {
            int matchCount = 0;
            boolean bonusMatch = false;

            for (int number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
                if (number == bonusNumber) {
                    bonusMatch = true;
                }
            }
            Score score = Score.getScore(matchCount, bonusMatch);
            resultCount.put(score, resultCount.getOrDefault(score, 0) + 1);
        }
        return resultCount;
    }
}
