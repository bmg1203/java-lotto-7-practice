package lotto.view;

import lotto.model.Rank;

import java.util.Map;

public class LottoVerificationView {
    public static void printResult(Map<Rank, Integer> rankCounts, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Rank[] displayOrder = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};


        for (Rank rank : displayOrder) {
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.println(rank.getMatchNumberCount() + "개 일치"
                    + (rank.isMatchBonusNumber() ? ", 보너스 볼 일치" : "")
                    + " (" + rank.getFormattedPrize() + "원) - "
                    + count + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }

}
