package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.util.Constants;
import lotto.util.Ranks;

/**
 * 수익률 계산기
 */
public class RevenuePercentCalculator {

    private final List<Long> rankCount;

    public RevenuePercentCalculator(List<Long> rankCount) {
        this.rankCount = rankCount;
    }

    public BigDecimal getRevenuePercent() {
        BigDecimal revenueSum = BigDecimal.ZERO;
        ;
        long moneySpent = rankCount.stream().mapToLong(Long::longValue).sum() * Constants.LOTTO_PRICE.getNumber();

        for (Ranks rank : Ranks.values()) {
            revenueSum = revenueSum.add(getRevenue(rank));
        }

        return revenueSum.multiply(new BigDecimal("100"))
                .divide(new BigDecimal(Long.toString(moneySpent)), Constants.ROUND_TO.getNumber(),
                        RoundingMode.HALF_UP);
    }

    private BigDecimal getRevenue(Ranks rank) {
        long count = rankCount.get(rank.getNumber());
        int prize = rank.getPrize();

        return new BigDecimal(Long.toString(count * prize));
    }


}
