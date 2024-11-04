package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRank {

    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int price;

    LottoRank(final int matchCount, final int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoRank getLottoRank(final int matchCount, final boolean hasBonusNumber) {
        if (matchCount == SECOND.matchCount && hasBonusNumber) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }
}