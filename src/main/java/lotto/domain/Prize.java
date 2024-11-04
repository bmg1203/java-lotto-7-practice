package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeAmont;

    Prize(int matchCount, int prizeAmont){
        this.matchCount = matchCount;
        this.prizeAmont = prizeAmont;
    }

}
