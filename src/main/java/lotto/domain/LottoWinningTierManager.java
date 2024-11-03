package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import static lotto.constants.LottoConstants.MATCH_FIVE_COUNT;
import static lotto.constants.LottoConstants.ZERO;

public class LottoWinningTierManager {
    private final Map<LottoWinningTier, Integer> lottoWinningTiers;

    public LottoWinningTierManager() {
        lottoWinningTiers = new LinkedHashMap<>();
        lottoWinningTiers.put(LottoWinningTier.NONE, ZERO);
        lottoWinningTiers.put(LottoWinningTier.MATCH_THREE, ZERO);
        lottoWinningTiers.put(LottoWinningTier.MATCH_FOUR, ZERO);
        lottoWinningTiers.put(LottoWinningTier.MATCH_FIVE, ZERO);
        lottoWinningTiers.put(LottoWinningTier.MATCH_FIVE_WITH_BONUS, ZERO);
        lottoWinningTiers.put(LottoWinningTier.MATCH_SIX, ZERO);
    }

    public Map<LottoWinningTier, Integer> getLottoWinningTiers() {
        return lottoWinningTiers;
    }
    public int getWinningTierCount (LottoWinningTier lottoWinningTier) {
        return lottoWinningTiers.get(lottoWinningTier);
    }

    public int calculateTotalPrize() {
        return lottoWinningTiers.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public void increaseLottoWinningTier(int matchCount, boolean isBonusNumber) {
        if (matchCount == MATCH_FIVE_COUNT && isBonusNumber) {
            checkLottoWinningTier(matchCount, true);
            return;
        }
        checkLottoWinningTier(matchCount, isBonusNumber);
    }
    public void checkLottoWinningTier (int matchCount, boolean isBonusNumber) {
        lottoWinningTiers.put(
                LottoWinningTier.getMatchCountTier(matchCount, isBonusNumber),
                lottoWinningTiers.get(LottoWinningTier.getMatchCountTier(matchCount, isBonusNumber)) + 1);
    }
}
