package lotto.domain;

public enum LottoRank {
    OTHER(0, false, 0, "꽝"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeAmount;
    private final String rankMessage;

    LottoRank(int matchCount, boolean bonusMatch, int prizeAmount, String rankMessage) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
        this.rankMessage = rankMessage;
    }

    public static LottoRank findByMatchCountAndBonus(int matchCount, boolean isBonus) {
        for (LottoRank value : LottoRank.values()) {
            if (value.isMatchCountAndBonus(matchCount, isBonus)) {
                return value;
            }
        }
        return OTHER;
    }

    private boolean isMatchCountAndBonus(int matchCount, boolean isBonus) {
        return this.matchCount == matchCount && this.bonusMatch == isBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getRankMessage() {
        return rankMessage;
    }
}
