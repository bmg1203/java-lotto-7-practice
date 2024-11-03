package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize getPrize(int matchCount, boolean isMatchBonusNumber) {
        if (matchCount == 5 && isMatchBonusNumber) {
            return SECOND;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}