package lotto.model;

import lotto.util.common.Limit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCalculator {
    public List<Rank> compareLottos(List<Lotto> lottos, WinningNumber winningNumber) {
        return lottos.stream()
                .map(lotto -> {
                    int matchedNumbersCount = compareSingleLotto(lotto, winningNumber);
                    return determineRank(matchedNumbersCount, checkBonusNumber(lotto, winningNumber));
                })
                .toList();
    }

    public boolean checkBonusNumber(Lotto userLotto, WinningNumber winningNumber) {
        return userLotto.getNumbers().contains(winningNumber.getBonusNumber().bonusNumber());
    }

    private int compareSingleLotto(Lotto userLotto, WinningNumber winningNumber) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningNumber.getWinningNumber().getNumbers()::contains)
                .count();
    }

    public Rank determineRank(int matchCount, boolean isBonusContain) {
        return Rank.valueOf(matchCount, isBonusContain);
    }

    public Map<Rank, Integer> finalRank(List<Rank> ranking) {
        Map<Rank, Integer> ranks = initializeRanks();

        for (Rank rank : ranking) {
            ranks.put(rank, ranks.get(rank) + Limit.INCREASE_UNIT.getValue());
        }

        return ranks;
    }

    private Map<Rank, Integer> initializeRanks() {
        Map<Rank, Integer> ranks = new HashMap<>();

        for (Rank rank : Rank.values()) {
            ranks.put(rank, Limit.DEFAULT.getValue());
        }

        return ranks;
    }
}
