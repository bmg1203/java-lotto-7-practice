package calculator;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lottoManager.LottoWinningResult;
import rank.LottoRank;

public class TotalProfitRateCalculator {

    private static final double PERCENTAGE_MULTIPLIER = 100.0;
    private static final int LOTTO_PRICE_UNIT = 1000;


    public static double calculateTotalProfitRate(LottoWinningResult result, long buyQuantity) {
        Map<LottoRank, Integer> lottoResult = result.getLottoResult();
        long calculatedWinningAmount = calculateWinningAmount(lottoResult);
        double totalProfitRate = ((PERCENTAGE_MULTIPLIER * calculatedWinningAmount) / (buyQuantity * LOTTO_PRICE_UNIT));

        return totalProfitRate;
    }


    private static long calculateWinningAmount(Map<LottoRank, Integer> lottoResult) {
        long totalWinningAmount = 0;
        Set<Entry<LottoRank, Integer>> resultEntries = lottoResult.entrySet();
        for (Entry<LottoRank, Integer> resultEntry : resultEntries) {
            LottoRank resultRank = resultEntry.getKey();
            long winningAmountPrice = resultRank.getWinningAmount();
            totalWinningAmount = totalWinningAmount + winningAmountPrice * resultEntry.getValue();
        }
        return totalWinningAmount;
    }
}
