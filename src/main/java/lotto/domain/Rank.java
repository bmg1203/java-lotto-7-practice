package lotto.domain;

public enum Rank {

    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    NONE(0, 0, "");

    private final int matchCount;
    private final long prize;
    private final String displayMessage;

    Rank(int matchCount, long prize, String displayMessage) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.displayMessage = displayMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public static Rank fromMatchCount(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }
}
