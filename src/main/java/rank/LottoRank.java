package rank;


import static constant.RankConst.*;

public enum LottoRank {

    FIRST(6, false, 2_000_000_000, MATCH_SIX),
    SECOND(5, true, 30_000_000, MATCH_FIVE_WITH_BONUS),
    THIRD(5, false, 1_500_000, MATCH_FIVE),
    FOURTH(4, false, 50_000, MATCH_FOUR),
    FIFTH(3, false, 5_000, MATCH_THREE),
    FAIL(0, false, 0, MATCH_FAIL);


    private final int matchCount;
    private final boolean isMatchBonus;
    private final int winningAmount;
    private final String rankMessage;


    LottoRank(int matchCount, boolean isMatchBonus, int winningAmount, String rankMessage) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.winningAmount = winningAmount;
        this.rankMessage = rankMessage;
    }


    public static LottoRank valueOf(int matchCount, boolean checkBonusNumber) {
        LottoRank[] lottoRanks = LottoRank.values();
        for (LottoRank lottoRank : lottoRanks) {
            if (lottoRank.getMatchCount() == matchCount && lottoRank.isMatchBonus() == checkBonusNumber) {
                return lottoRank;
            }
        }
        return FAIL;

    }


    private int getMatchCount() {
        return matchCount;
    }


    private boolean isMatchBonus() {
        return isMatchBonus;
    }


    public String getRankMessage() {
        return rankMessage;
    }


    public int getWinningAmount() {
        return winningAmount;
    }


}
