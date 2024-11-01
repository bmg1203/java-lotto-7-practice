package lotto.model.rank;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import lotto.model.money.Money;

public class DrawResultRankTable {

    private final EnumMap<RankCondition, Integer> result;

    private DrawResultRankTable(EnumMap<RankCondition, Integer> result) {
        this.result = result;
    }

    public static DrawResultRankTable initiate() {
        EnumMap<RankCondition, Integer> rankTable = new EnumMap<>(RankCondition.class);
        Arrays.stream(RankCondition.values())
                .forEach(rank -> rankTable.put(rank, 0));
        return new DrawResultRankTable(rankTable);
    }

    public void updateResultRankTable(final RankCondition rank) {
        int newValue = result.get(rank) + 1;
        result.put(rank, newValue);
    }

    public Money totalPrizeAmount() {
        List<Money> monies = result.entrySet()
                .stream()
                .filter(this::hasReward)
                .map(this::toMoney)
                .toList();
        return Money.addAll(monies);
    }

    private boolean hasReward(final Entry<RankCondition, Integer> entry) {
        Integer rankCount = entry.getValue();
        return rankCount > 0;
    }

    private Money toMoney(final Entry<RankCondition, Integer> entry) {
        RankCondition rank = entry.getKey();
        int prizeCount = entry.getValue();
        return rank.calculateReceivableTotalPrizeAmountBy(prizeCount);
    }

    public String toStringMessageOf(final RankCondition condition) {
        Integer prizeCount = result.getOrDefault(condition, 0);
        return String.format("%d개", prizeCount);
    }
}
