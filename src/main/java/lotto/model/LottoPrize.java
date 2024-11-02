package lotto.model;

import lotto.constant.LottoConstant;

public enum LottoPrize {
    
    FIFTH(LottoConstant.THREE_COUNT, LottoConstant.FIFTH_PRICE, false),
    FOURTH(LottoConstant.FOUR_COUNT, LottoConstant.FOURTH_PRICE, false),
    THIRD(LottoConstant.FIVE_COUNT, LottoConstant.THIRD_PRICE, false),
    SECOND(LottoConstant.FIVE_COUNT, LottoConstant.SECOND_PRICE, true),
    FIRST(LottoConstant.SIX_COUNT, LottoConstant.FIRST_PRICE, false);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean hasBonus;

    LottoPrize(int matchCount, int prizeAmount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.hasBonus = hasBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}
