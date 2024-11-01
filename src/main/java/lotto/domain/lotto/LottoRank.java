package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int price;

    LottoRank(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public LottoRank getLottoRank(int matchCount, boolean hasBonusNumber) {
        if (matchCount == SECOND.matchCount && hasBonusNumber) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrice() {
        return price;
    }
}