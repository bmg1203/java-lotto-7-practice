package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.Model.LottoStatistics;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void showLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void showAllLottos(List<Lotto> allLottos){
        for (Lotto lotto : allLottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(lotto.getNumbers());
        }
    }

    public static void showStatistics(LottoStatistics statistics){
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoResult result : LottoResult.values()) {
            System.out.printf("%개 일치 (%d원) - %d개%n",
                    result.getMatchCount(),
                    result.getWinningAmount(),
                    statistics.getResultCounts().get(result));
        }
    }
    public static void showProfitRate(LottoStatistics statistics){
        System.out.printf("총 수익률은 %.1f%%입니다.%n", statistics.calculateProfitRate());
    }
}
