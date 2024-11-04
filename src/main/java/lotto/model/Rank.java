package lotto.model;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.matches(matchCount, matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }

    private boolean matches(int matchCount, boolean matchBonus) {
        return this.matchCount == matchCount && (!this.matchBonus || matchBonus);
    }
}
