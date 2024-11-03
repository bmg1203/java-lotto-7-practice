package lotto.model;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public Map<LottoPrizeType, Integer> matchCountWithBonus(Lotto winningLotto, LottoBonusNumber bonusNumber) {
        Map<LottoPrizeType, Integer> lottoPrizes = initializePrizeCountSetting();

        for (Lotto lotto : lottoBundle) {
            LottoPrizeType prizeType = calculatePrizeType(lotto, winningLotto, bonusNumber);
            if (prizeType != null) {
                lottoPrizes.put(prizeType, lottoPrizes.get(prizeType) + 1);
            }
        }
        return lottoPrizes;
    }

    private Map<LottoPrizeType, Integer> initializePrizeCountSetting() {
        Map<LottoPrizeType, Integer> lottoPrizes = new TreeMap<>(Comparator.reverseOrder());
        for (LottoPrizeType prizeType : LottoPrizeType.values()) {
            lottoPrizes.put(prizeType, 0);
        }
        return lottoPrizes;
    }

    private LottoPrizeType calculatePrizeType(Lotto lotto, Lotto winningLotto, LottoBonusNumber bonusNumber) {
        int matchedCount = lotto.matchCountWithBonus(winningLotto, bonusNumber);

        for (LottoPrizeType prizeType : LottoPrizeType.values()) {
            if (isEligibleForPrize(matchedCount, lotto, prizeType, bonusNumber)) {
                return prizeType;
            }
        }
        return null;
    }

    private boolean isEligibleForPrize(int matchedCount, Lotto lotto, LottoPrizeType prizeType, LottoBonusNumber bonusNumber) {
        return matchedCount == prizeType.getRequiredCorrectCount() &&
                (!prizeType.requiresBonusNumber() || lotto.isBonusMatched(bonusNumber));
    }


    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }

    public int getLottoAmount() {
        return lottoBundle.size();
    }
}
