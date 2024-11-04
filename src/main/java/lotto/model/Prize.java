package lotto.model;

import java.util.List;
import java.util.stream.IntStream;

public class Prize {
    private static final int FIRST_PRIZE = 2000000000;
    private static final int SECOND_PRIZE = 30000000;
    private static final int THIRD_PRIZE = 1500000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int FIFTH_PRIZE = 5000;
    private static final List<Integer> prizes = List.of(FIFTH_PRIZE,
            FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE);
    private static final int START_INDEX = 0;
    private final List<Integer> rankCount;
    private final int profit;
    private final double profitRate;

    public Prize(List<Integer> rankCount, int investment) {
        this.rankCount = rankCount;
        this.profit = calculateProfit(rankCount);
        this.profitRate = calculateProfitRate(investment, profit);
    }

    private int calculateProfit(List<Integer> rankCount) {
        return IntStream.range(START_INDEX, rankCount.size())
                .map(idx -> prizes.get(idx) * rankCount.get(idx))
                .sum();
    }

    private double calculateProfitRate(int investment, int profit) {
        return (double) profit / investment * 100;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
