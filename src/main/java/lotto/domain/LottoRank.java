package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchCount && lottoRank.matchBonus == matchBonus) {
                return lottoRank;
            }
        }
        return MISS;
    }

    public int getPrize() {
        return prize;
    }
}
