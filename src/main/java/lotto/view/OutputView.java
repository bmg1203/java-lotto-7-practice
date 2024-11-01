package lotto.view;

import java.util.List;
import lotto.model.constant.Match;

public class OutputView {
    private static void printEnter() {
        System.out.println();
    }

    public static void printBuyLotto(final int amount) {
        printEnter();
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(final List<List<Integer>> numbers) {
        for (List<Integer> number : numbers) {
            System.out.println(number);
        }
        printEnter();
    }

    public static void printMatchNumbers(final int three, final int four, final int five, final int fiveAndBonus, final int six) {
        printResult();
        System.out.println(Match.THREE.getMatchCount() + "개 일치 (" + Match.THREE.getReward() + ") - " + three + "개");
        System.out.println(Match.FOUR.getMatchCount() + "개 일치 (" + Match.FOUR.getReward() + ") - " + four + "개");
        System.out.println(Match.FIVE.getMatchCount() + "개 일치 (" + Match.FIVE.getReward() + ") - " + five + "개");
        System.out.println(Match.BONUS.getMatchCount() + "개 일치, 보너스 볼 일치 (" + Match.BONUS.getReward() + ") - " + fiveAndBonus + "개");
        System.out.println(Match.SIX.getMatchCount() + "개 일치 (" + Match.SIX.getReward() + ") - " + six + "개");
    }

    private static void printResult() {
        printEnter();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printProfit(final double rate) {
        System.out.println("총 수익률은 " + rate +"%입니다.");
    }
}
