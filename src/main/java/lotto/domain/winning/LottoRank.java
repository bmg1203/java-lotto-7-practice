package lotto.domain.winning;

import java.util.Arrays;

public enum LottoRank {

    NONE(0L),
    FIFTH(5_000L, 3),
    FOURTH(50_000L, 4),
    THIRD(1_500_000L, 5, false),
    SECOND(30_000_000L, 5, true),
    FIRST(2_000_000_000L, 6);

    private final long winningMoney;
    private int matchingCount;
    private boolean hasBonusNumber;

    LottoRank(final long winningMoney) {
        this.winningMoney = winningMoney;
    }

    LottoRank(final long winningMoney, final int matchingCount) {
        this.winningMoney = winningMoney;
        this.matchingCount = matchingCount;
    }

    LottoRank(final long winningMoney, final int matchingCount, final boolean hasBonusNumber) {
        this.winningMoney = winningMoney;
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoRank find(final int matchingCount, final boolean hasBonusNumber) {
        if (isSecond(matchingCount, hasBonusNumber)) {
            return SECOND;
        }
        return findByMatchingCount(matchingCount);
    }

    private static boolean isSecond(final int matchingCount, final boolean hasBonusNumber) {
        return matchingCount == SECOND.matchingCount && hasBonusNumber;
    }

    private static LottoRank findByMatchingCount(final int matchingCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchingCount == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

    public long calculateWinningMoneyTotal(final Long winningCount) {
        return this.winningMoney * winningCount;
    }

    public long winningMoney() {
        return this.winningMoney;
    }

    public int matchingCount() {
        return this.matchingCount;
    }
}
