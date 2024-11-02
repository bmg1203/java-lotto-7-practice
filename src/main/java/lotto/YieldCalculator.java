package lotto;

import java.util.Map;
import lotto.score.Prize;

public class YieldCalculator {

    public int calculatePrizeMoney(Map<Prize, Integer> lottoScore) {
        int prizeMoney = 0;
        for (Prize prize : Prize.values()) {
            prizeMoney += prize.calculatePrizeMoney(lottoScore.get(prize));
        }
        return prizeMoney;
    }

    public String calculateRateOfReturn(int investmentMoney, int prizeMoney) {
        return String.format("%.1f", (double) prizeMoney / investmentMoney * 100) + "%";
    }
}
