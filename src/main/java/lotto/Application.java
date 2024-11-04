package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input_text = "";
        int purchaseAmount = 0;
        List<Integer> winningNums = new ArrayList<>();
        int bonusNum = 0;
        List<Lotto> lottos = new ArrayList<Lotto>();
        int[] winningResult = new int[7];
        long totalWinning = 0;
        String resultRate;

        InputHandler inputHandler = new InputHandler();
        LottoWinningChecker winningChecker;

        purchaseAmount = inputHandler.getPurchaseAmount();

        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(nums));
        }

        System.out.println("\n" + Integer.toString(purchaseAmount) + GuideMessage.INPUT_PURCHASE_RESULT.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }

        winningNums = inputHandler.getWinningNumbers();
        bonusNum = inputHandler.getBonusNumber();

        winningChecker = new LottoWinningChecker(winningNums, bonusNum);

        for (Lotto lotto : lottos) {
            int winningGrade = winningChecker.getWinningGrade(lotto);
            winningResult[winningGrade] += 1;
        }

        System.out.println(GuideMessage.OUTPUT_WINNING_STATS.getMessage());
        for (int i = 5; i > 0; i--) {
            String match = LottoWinningAmount.findByRank(i).getMatch();
            long winning_n = LottoWinningAmount.findByRank(i).getWinning();
            String winning = String.format("%,d", winning_n);

            System.out.println(match + " (" + winning + "원) - " + winningResult[i] + "개");
            totalWinning += winning_n * winningResult[i];
        }

        resultRate = String.format("%.1f", (double) (totalWinning * 100) / (purchaseAmount * 1000));
        System.out.println("총 수익률은 " + resultRate + "%입니다.");
    }
}
