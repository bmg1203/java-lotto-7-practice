package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoProfitCalculator;
import lotto.domain.Rank;

public class LottoResultAnalysisService {

    private final Lotto winningNumbers;
    private final LottoProfitCalculator lottoProfitCalculator;

    public LottoResultAnalysisService(List<Integer> winningNumbers) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.lottoProfitCalculator = new LottoProfitCalculator();
    }

    public List<Rank> generateWinningResults(List<Lotto> lottos) {
        List<Rank> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchedCount = countDuplicate(lotto);

            results.add(Rank.findByMatchedCount(matchedCount));
        }
        return results;
    }

    private int countDuplicate(Lotto lotto) {
        Set<Integer> uniqueWinningNumber = new HashSet<>(winningNumbers.getNumbers());
        int count = 0;

        for (int num : lotto.getNumbers()) {
            if (!uniqueWinningNumber.add(num)) {
                count++;
            }
        }
        return count;
    }

    // TODO: payment를 wrapping.?
    public String getLottoProfitRate(List<Rank> winningResults, int payment) {
        BigDecimal profit = lottoProfitCalculator.getProfit(winningResults);
        BigDecimal profitRate = lottoProfitCalculator.getProfitRate(profit, payment);
        return profitRate.toPlainString();
    }
}
