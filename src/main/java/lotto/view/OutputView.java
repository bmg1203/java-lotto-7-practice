package lotto.view;

import lotto.domain.Lotto;
import java.util.List;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printResult(String result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public static void printYield(double yield){
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}