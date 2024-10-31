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

    Rank(final int matchCount, final boolean matchBonus, final int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for(Rank rank : Rank.values()) {
            if(rank.matchCount == matchCount && (!rank.matchBonus || matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}
