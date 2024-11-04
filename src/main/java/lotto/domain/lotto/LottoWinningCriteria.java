package lotto.domain.lotto;

public enum LottoWinningCriteria {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int matchCount;
    private final boolean checkBonus;
    private final int prizeMoney;

    LottoWinningCriteria(int matchCount, boolean checkBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.checkBonus = checkBonus;
        this.prizeMoney = prizeMoney;
    }

    public static LottoWinningCriteria findWinningCriteria(int matchCount, boolean matchBonus) {
        for (LottoWinningCriteria winningCriteria : LottoWinningCriteria.values()) {
            if (winningCriteria.checkBonus && matchBonus && winningCriteria.matchCount == matchCount) {
                return winningCriteria;
            }
            if (!winningCriteria.checkBonus && winningCriteria.matchCount == matchCount) {
                return winningCriteria;
            }
        }
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isCheckBonus() {
        return checkBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
