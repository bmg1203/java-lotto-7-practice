package lotto.service;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.money.Money;
import lotto.model.result.EarningsRate;
import lotto.model.result.Rank;
import lotto.model.result.RankResult;

public class ResultService {

    public ResultService() {
    }

    public RankResult getRankResult(final Lottos lottos, final Lotto winningLotto, final int bonusNumber) {
        RankResult rankResult = RankResult.initiate();

        lottos.getLottos().forEach(lotto -> {
            Rank rank = getEachRank(lotto, winningLotto, bonusNumber);
            rankResult.compute(rank);
        });

        return rankResult;
    }

    private Rank getEachRank(final Lotto lotto, final Lotto winningLotto, final int bonusNumber) {
        int matchingCount = lotto.countMatch(winningLotto);
        boolean bonusMatched = hasBonusMatched(lotto, matchingCount, bonusNumber);
        return Rank.findRank(matchingCount, bonusMatched);
    }

    private boolean hasBonusMatched(final Lotto lotto, final int matchingCount, final int bonusNumber) {
        return Rank.hasCountToBeSecond(matchingCount) && lotto.hasBonus(bonusNumber);
    }

    public EarningsRate getEarningsRate(final RankResult rankResult, final Money purchaseAmount) {
        Money totalPrize = rankResult.calculateTotalPrize();
        return EarningsRate.from(totalPrize, purchaseAmount);
    }
}
