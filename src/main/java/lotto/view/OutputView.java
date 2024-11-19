package lotto.view;

import java.util.Arrays;
import lotto.constants.OutputPrompts;
import lotto.constants.Prize;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Purchase;
import lotto.domain.WinningResult;

public class OutputView {

    public void purchasePrint(Purchase purchase, LottoGenerator lottoGenerator) {
        System.out.printf(OutputPrompts.PURCHASE_COUNT_OUTPUT.getPrompt(), purchase.purchaseCount());
        for (Lotto lotto : lottoGenerator.getLottos()) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public void resultPrint(WinningResult winningResult) {
        System.out.print(OutputPrompts.WINNING_STATISTICS_HEADER_OUTPUT.getPrompt());

        winningCountPrint(winningResult);
        returnRatePrint(winningResult);
    }

    private void winningCountPrint(WinningResult winningResult) {
        System.out.printf(OutputPrompts.FIFTH_PLACE_COUNT_OUTPUT.getPrompt(), winningResult.getWinningCount().getOrDefault(Prize.FIFTH.getPlace(), 0));
        System.out.printf(OutputPrompts.FOURTH_PLACE_COUNT_OUTPUT.getPrompt(), winningResult.getWinningCount().getOrDefault(Prize.FOURTH.getPlace(), 0));
        System.out.printf(OutputPrompts.THIRD_PLACE_COUNT_OUTPUT.getPrompt(), winningResult.getWinningCount().getOrDefault(Prize.THIRD.getPlace(), 0));
        System.out.printf(OutputPrompts.SECOND_PLACE_COUNT_OUTPUT.getPrompt(), winningResult.getWinningCount().getOrDefault(Prize.SECOND.getPlace(), 0));
        System.out.printf(OutputPrompts.FIRST_PLACE_COUNT_OUTPUT.getPrompt(), winningResult.getWinningCount().getOrDefault(Prize.FIRST.getPlace(), 0));
    }

    private void returnRatePrint(WinningResult winningResult) {
        System.out.printf(OutputPrompts.RATE_OF_RETURN_OUTPUT.getPrompt(), winningResult.getReturnRate());
    }
}
