// Rank.java

package lotto;

public enum Rank {
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - ");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    private final String displayMessage;

    Rank(int matchCount, boolean bonusMatch, int prize, String displayMessage) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.displayMessage = displayMessage;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return null;
    }

    public int getPrize() {
        return prize;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }
}