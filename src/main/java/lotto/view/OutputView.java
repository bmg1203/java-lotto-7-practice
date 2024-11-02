package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PrizeCount;

import java.util.List;

public class OutputView {

    /**
     * 발행된 로또 번호들 출력
     */
    public static void printMyLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    /**
     * 당첨 통계 출력
     */
    public static void printPrizeResult(PrizeCount prizeCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeCount.getFifthPrizeCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCount.getFourthPrizeCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount.getThirdPrizeCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount.getSecondPrizeCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount.getFirstPrizeCount() + "개");
    }
}
