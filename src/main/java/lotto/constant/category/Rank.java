package lotto.constant.category;

public enum Rank {

    FIRST_PLACE(6, false, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, false, 1500000),
    FOURTH_PLACE(4, false, 50000),
    FIFTH_PLACE(3, false, 5000),
    LAST_PLACE(0, false, 0)
    ;

    private final Integer matchCount;
    private final boolean requireBonusNumberMismatch;
    private final Integer prizeAmount;

    Rank(Integer matchCount, boolean requireBonusNumberMismatch, Integer prizeAmount) {
        this.matchCount = matchCount;
        this.requireBonusNumberMismatch = requireBonusNumberMismatch;
        this.prizeAmount = prizeAmount;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    private boolean isRequireBonusNumberMismatch() {
        return requireBonusNumberMismatch;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    public static Rank getRankByMatch(Integer matchCount, boolean isBonusNumberMatched) {
        for (Rank rank : Rank.values()) {
            if (isRankMatched(rank, matchCount, isBonusNumberMatched)) {
                return rank;
            }
        }
        return LAST_PLACE;
    }

    private static boolean isRankMatched(Rank rank, Integer matchCount, boolean isBonusNumberMatched) {
        if (rank.isRequireBonusNumberMismatch()) {
            return rank.getMatchCount().equals(matchCount) && !isBonusNumberMatched;
        }
        return rank.getMatchCount().equals(matchCount) ||
                (rank.getMatchCount().equals(matchCount + 1) && isBonusNumberMatched);
    }
}
