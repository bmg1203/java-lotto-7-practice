package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public enum LottoResult {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    NONE(0, 0, "");

    private final int matchCount;
    private final int prize;

    private final String description;

    LottoResult(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static LottoResult of(int matchCount, boolean isMatchBonus) {
        if (matchCount == FIRST.matchCount) return FIRST;
        if (matchCount == SECOND.matchCount && isMatchBonus) return SECOND;
        if (matchCount == THIRD.matchCount) return THIRD;
        if (matchCount == FOURTH.matchCount) return FOURTH;
        if (matchCount == FIFTH.matchCount) return FIFTH;
        return NONE;
    }

    public static final List<LottoResult> values = Stream.of(values())
            .sorted(Comparator.reverseOrder())
            .filter(result -> result != NONE)
            .toList();

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
