package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    public static void printPurchaseInfo(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printWinningStatistics(List<Integer> matchCounts, double profitRate) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts.get(4));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
