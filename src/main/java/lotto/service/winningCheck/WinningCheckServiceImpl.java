package lotto.service.winningCheck;

import lotto.model.Lotto;
import lotto.model.PrizeTier;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;

public class WinningCheckServiceImpl implements WinningCheckService {
    @Override
    public int checkPrize(Lotto lotto, WinningNumbers winningNumbers, WinningStatistic winningStatistic) {
        int matchCount = winningNumbers.getMatchCount(lotto);
        boolean bonusMatch = winningNumbers.isBonusNumberMatched(lotto);

        // PrizeTier를 순회하여 일치하는 등수 반환
        for (PrizeTier tier : PrizeTier.values()) {
            if (tier.getMatchCount() == matchCount && tier.isBonusMatch() == bonusMatch) {
                winningStatistic.addPrizeCount(tier);
                return tier.getPrizeAmount();
            }
        }
        return 0;
    }
}
