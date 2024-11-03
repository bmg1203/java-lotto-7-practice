package lotto.domain;

import static lotto.domain.LottoConstants.NOT_MATCH_COUNT;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public enum LottoRank {
    NONE(0, 0, Arrays.asList(0, 1, 2), false),
    FIFTH(5, 5_000, Arrays.asList(3), false),
    FOURTH(4, 50_000, Arrays.asList(4), false),
    THIRD(3, 1_500_000, Arrays.asList(5), false),
    SECOND(2, 30_000_000, Arrays.asList(5), true),
    FIRST(1, 2_000_000_000, Arrays.asList(6), false);


    private final int matchRank;
    private final int prizeMoney;
    private final List<Integer> matchCounts;
    private final boolean matchBonus;

    LottoRank(int matchRank, int prizeMoney, List<Integer> matchCounts, boolean matchBonus) {
        this.matchRank = matchRank;
        this.prizeMoney = prizeMoney;
        this.matchCounts = matchCounts;
        this.matchBonus = matchBonus;
    }

    public static LottoRank matchRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> {
                    if (matchCount == 5) {
                        return rank == LottoRank.SECOND && matchBonus || rank == LottoRank.THIRD && !matchBonus;
                    }
                    return rank.getMatchCounts().contains(matchCount);
                })
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_COUNT));
    }

    public static EnumMap<LottoRank, Integer> initializePrizeCount() {
        EnumMap<LottoRank, Integer> prizeCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            prizeCount.put(rank, 0);
        }
        return prizeCount;
    }


    public int getPrizeMoney() {
        return prizeMoney;
    }

    public List<Integer> getMatchCounts() {
        return matchCounts;
    }
}
