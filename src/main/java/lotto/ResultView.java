package lotto;

import lotto.Lotto;
import java.util.List;

public class ResultView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

	public static void printYield(double yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

}