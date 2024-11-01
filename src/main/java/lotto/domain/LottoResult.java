package lotto.domain;

import static lotto.constant.LottoConstants.LOTTO_PRICE;
import static lotto.constant.Winner.FIFTH_WINNER;
import static lotto.constant.Winner.FIRST_WINNER;
import static lotto.constant.Winner.FOURTH_WINNER;
import static lotto.constant.Winner.SECOND_WINNER;
import static lotto.constant.Winner.THIRD_WINNER;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> result;
    private final int count;

    public LottoResult(int count) {
        this.result = new HashMap<>();
        this.count = count;
    }

    public void updateLottoResult(int matchCount, boolean isBonusMatched) {
        if (matchCount == FIRST_WINNER.getMatchCount()) {
            int key = FIRST_WINNER.getRank();
            if (isBonusMatched) {
                key = SECOND_WINNER.getRank();
            }
            result.put(key, result.getOrDefault(key, 0) + 1);
        } else if (matchCount == THIRD_WINNER.getMatchCount()) {
            result.put(THIRD_WINNER.getRank(), result.getOrDefault(THIRD_WINNER.getRank(), 0) + 1);
        } else if (matchCount == FOURTH_WINNER.getMatchCount()) {
            result.put(FOURTH_WINNER.getRank(), result.getOrDefault(FOURTH_WINNER.getRank(), 0) + 1);
        } else if (matchCount == FIFTH_WINNER.getMatchCount()) {
            result.put(FIFTH_WINNER.getRank(), result.getOrDefault(FIFTH_WINNER.getRank(), 0) + 1);
        }
    }

    public double calculateRateOfReturn() {
        double totalRevenue = result.getOrDefault(FIRST_WINNER.getRank(), 0) * FIRST_WINNER.getPrizeMoney()
                + result.getOrDefault(SECOND_WINNER.getRank(), 0) * SECOND_WINNER.getPrizeMoney()
                + result.getOrDefault(THIRD_WINNER.getRank(), 0) * THIRD_WINNER.getPrizeMoney()
                + result.getOrDefault(FOURTH_WINNER.getRank(), 0) * FOURTH_WINNER.getPrizeMoney()
                + result.getOrDefault(FIFTH_WINNER.getRank(), 0) * FIFTH_WINNER.getPrizeMoney();

        int totalInvest = count * LOTTO_PRICE;
        double rateOfReturn = (totalRevenue / totalInvest) * 100;
        return Math.round(rateOfReturn * 100.0) / 100.0;
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }
}
