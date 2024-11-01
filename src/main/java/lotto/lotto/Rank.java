package lotto.lotto;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int prize;

    Rank(int matchCount, boolean hasBonusNumber, int prize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean hasBonusNumber) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }

        if (matchCount == SECOND.matchCount && hasBonusNumber) {
            return SECOND;
        }

        if (matchCount == SECOND.matchCount) {
            return THIRD;
        }

        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }

        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }

        return NONE;
    }
}
