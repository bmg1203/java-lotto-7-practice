package lotto.model;

import java.util.Map;
import java.util.HashMap;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    NONE(0, 0, "당첨 없음");

    private static final Map<String, Rank> RANK_MAP = new HashMap<>();

    static {
        RANK_MAP.put("6,false", FIRST);
        RANK_MAP.put("5,true", SECOND);
        RANK_MAP.put("5,false", THIRD);
        RANK_MAP.put("4,false", FOURTH);
        RANK_MAP.put("3,false", FIFTH);
    }

    private final int matchCount;
    private final int prize;
    private final String description;

    Rank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        return RANK_MAP.getOrDefault(matchCount + "," + matchBonus, NONE);
    }
}
