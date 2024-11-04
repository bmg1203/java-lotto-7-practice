package view;

import calculator.TotalProfitRateCalculator;
import formatter.Formatter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.Lotto;
import lotto.PurchasedLotto;
import lottoManager.LottoWinningResult;
import observer.Observer;
import rank.LottoRank;

public class OutputViewImpl implements OutputView {

    private static final String PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String SEPARATOR_LINE = "---";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String RANK_MESSAGE_FORMAT = "%s - %s개";
    private static final String EMPTY_LINE = "";


    public void showQuantityView(long buyQuantity) {
        if (buyQuantity != 0) {
            System.out.println(EMPTY_LINE);
            System.out.printf(PURCHASED_MESSAGE, buyQuantity);
            System.out.println(EMPTY_LINE);
        }

    }


    public void showMyPurchasedLotto(List<Observer> myWholeLotto) {

        for (Observer myLotto : myWholeLotto) {
            Lotto lotto = ((PurchasedLotto) myLotto).getMyLotto();
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            System.out.println(lottoNumbers);
        }
    }


    public void displayFinalResult(LottoWinningResult result, long buyQuantity) {
        System.out.println(EMPTY_LINE);
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(SEPARATOR_LINE);

        Map<LottoRank, Integer> lottoResult = result.getLottoResult();
        showLottoResults(lottoResult);

        showTotalProfitRate(result, buyQuantity);

    }


    private void showLottoResults(Map<LottoRank, Integer> lottoResult) {
        NumberFormat numberFormat =Formatter.getNumberFormatWithoutDecimal();
        for (Map.Entry<LottoRank, Integer> resultEntry : lottoResult.entrySet()) {
            LottoRank resultRank = resultEntry.getKey();
            Integer resultCount = resultEntry.getValue();
            String formatedResultCount = numberFormat.format(resultCount);

            System.out.printf(RANK_MESSAGE_FORMAT, resultRank.getRankMessage(), formatedResultCount);
            System.out.println(EMPTY_LINE);
        }
    }


    private void showTotalProfitRate(LottoWinningResult result, long buyQuantity) {
        double totalProfitRate = TotalProfitRateCalculator.calculateTotalProfitRate(result, buyQuantity);

        NumberFormat numberFormat =Formatter.getNumberFormatWithOneDecimal();

        String formatedTotalProfitRate = numberFormat.format(totalProfitRate);
        System.out.printf(TOTAL_PROFIT_MESSAGE, formatedTotalProfitRate);
        System.out.println(EMPTY_LINE);
    }




}
