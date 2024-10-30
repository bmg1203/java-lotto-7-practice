package lotto.view;

import lotto.dto.LottoDto;
import lotto.service.WinningResult;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASE_QUANTITY = "개를 구매했습니다.";
    private static final String WINNING_RESULT = "\n당첨 통계\n---\n";
    private static final String TOTAL_RATE = "총 수익률은 %.1f";
    private static final String PERCENTAGE = "% 입니다";

    public void printPurchaseAmount(final int amount) {
        System.out.println(amount + PURCHASE_QUANTITY);
    }

    public void printPurchasedLottos(final List<LottoDto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (LottoDto lotto : lottos) {
            sb.append(lotto).append('\n');
        }
        System.out.println(sb);
    }

    public void printLottoResults(final Map<WinningResult, Integer> results) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_RESULT);

        for (WinningResult winningResult : results.keySet()) {
            String s = winningResult.makeSentence(results.get(winningResult));
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }

    public void printTotalRate(double rate) {
        String format = String.format(TOTAL_RATE, rate);
        System.out.print(format + PERCENTAGE);
    }
}
