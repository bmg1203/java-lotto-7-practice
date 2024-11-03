package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.Lotto;
import lotto.LottoPurchaseInfo;
import lotto.LottoRank;
import lotto.LottoResult;
import lotto.Lottos;

public class LottoService {

    public BigDecimal calculateReturnOnInvestment(LottoPurchaseInfo purchaseInfo, LottoResult lottoResult) {
        BigDecimal purchaseAmount = purchaseInfo.getPurchaseAmount();
        BigDecimal totalPrize = lottoResult.calculateTotalPrize();
        BigDecimal percentage = new BigDecimal("100");

        return totalPrize.multiply(percentage)
                         .divide(purchaseAmount, 1, RoundingMode.HALF_UP);
    }

    public LottoResult calculateLottoResult(Lottos lottos, Lotto userLotto, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();

        lottos.getLottos()
              .stream()
              .map(lotto -> calculateLottoRank(lotto, userLotto, bonusNumber))
              .forEach(lottoResult::addRankCount);

        return lottoResult;
    }

    private LottoRank calculateLottoRank(Lotto generatedLotto, Lotto userLotto, int bonusNumber) {
        int matchCount = generatedLotto.countMatchingNumbers(userLotto);
        boolean isBonusMatched = generatedLotto.containsNumber(bonusNumber);
        return LottoRank.findRankByMatches(matchCount, isBonusMatched);
    }

    public BigDecimal calculatePurchaseQuantity(BigDecimal purchaseAmount) {
        return purchaseAmount.divide(BigDecimal.valueOf(1000));
    }
}
