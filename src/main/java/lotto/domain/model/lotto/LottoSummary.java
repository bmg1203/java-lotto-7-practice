package lotto.domain.model.lotto;

import java.util.Map;

public class LottoSummary {

    Map<LottoRank, Long> resultMap;

    private LottoSummary(Map<LottoRank, Long> resultMap) {
        this.resultMap = resultMap;
    }

    public static LottoSummary create(Map<LottoRank, Long> resultMap) {
        return new LottoSummary(resultMap);
    }

    public Long getWinningCount(LottoRank rank, long defaultValue) {
        return this.resultMap.getOrDefault(rank, defaultValue);
    }

    public double getProfitRate(int totalPurchaseAmount) {
        long totalPrize = resultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = (double) totalPrize / totalPurchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0;
    }

    public int getSize() {
        return resultMap.size();
    }
}
