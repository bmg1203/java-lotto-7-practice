package lotto.view;

import lotto.enums.LottoRank;
import lotto.enums.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LABEL_WINNING_STATISTICS = "당첨 통계";
    private static final String SYMBOL_SEPARATOR_LINE = "---";

    public void printPurchaseAmountInputMessage() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void printBonusNumberInputMessage() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printPurchaseCount(int count) {
        String message = String.format(Message.PURCHASE_SUFFIX.getMessage(), count);
        System.out.println(message);
    }

    public void printPurchasedLottoNumbers(List<Integer> lottoNumbers) {
        List<Integer> numbers = sortAscending(lottoNumbers);
        System.out.println(numbers);
    }

    public List<Integer> sortAscending(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public void printWinningStatistics(Map<LottoRank, Integer> lottoRankCount) {
        System.out.println(LABEL_WINNING_STATISTICS);
        System.out.println(SYMBOL_SEPARATOR_LINE);

        Map<LottoRank, String> rankInfo = LottoRank.getRankInfo();

        for (LottoRank rank : rankInfo.keySet()) {
            int count = lottoRankCount.getOrDefault(rank, 0);
            System.out.printf("%s - %d개%n", rankInfo.get(rank), count);
        }
    }

    public void printTotalProfitRate(double profitRate) {
        System.out.printf(Message.TOTAL_PROFIT_RATE.getMessage(), profitRate);
    }
}
