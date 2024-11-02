package lotto.core.model;

import java.math.BigDecimal;
import java.util.Arrays;

public enum WinningRank {

    RANK_1(1, 6, false, BigDecimal.valueOf(2_000_000_000L)),
    RANK_2(2, 5, true, BigDecimal.valueOf(30_000_000L)),
    RANK_3(3, 5, false, BigDecimal.valueOf(1_500_000L)),
    RANK_4(4, 4, false, BigDecimal.valueOf(50_000L)),
    RANK_5(5, 3, false, BigDecimal.valueOf(5_000L));

    private int rank;
    private int matchCount;
    private boolean isBonus;
    private BigDecimal winningAmount;

    WinningRank(int rank, int matchCount, boolean isBonus, BigDecimal winningAmount) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.winningAmount = winningAmount;
    }

    public int getRank() {
        return this.rank;
    }

    public boolean isBonus() {
        return this.isBonus;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public BigDecimal getWinningAmount() {
        return this.winningAmount;
    }

    public static WinningRank match(int matchCount, boolean matchBonus) {
        if (matchBonus) {
            WinningRank bonusRank = findBonusRank(matchCount);
            if (bonusRank != null) {
                return bonusRank;
            }
        }
        WinningRank[] notBonusRank = Arrays.stream(WinningRank.values())
                .filter(it -> !it.isBonus).toArray(WinningRank[]::new);
        return findMatchRank(notBonusRank, matchCount);
    }

    private static WinningRank findBonusRank(int matchCount) {
        WinningRank[] bonusRank = Arrays.stream(WinningRank.values())
                .filter(it -> it.isBonus).toArray(WinningRank[]::new);
        return findMatchRank(bonusRank, matchCount);
    }

    private static WinningRank findMatchRank(WinningRank[] ranks, int matchCount) {
        for (WinningRank rank : ranks) {
            if (rank.getMatchCount() == matchCount) {
                return rank;
            }
        }
        return null;
    }
}
