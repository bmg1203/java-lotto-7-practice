package lotto.view.output;

import java.util.Map;
import lotto.constatnt.WinningRank;
import lotto.model.Lottos;

public class ResultDisplayer {

    private static final String LOTTO_COUNT_MESSAGE_SUFFIX = "개를 구매했습니다.";

    public void showPurchasedLottos(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE_SUFFIX);
        lottos.getLottos().forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public void showWinningStatistics(Map<WinningRank, Integer> winningCounts) {
        System.out.println("---");

        for (WinningRank rank : WinningRank.values()) {
            if (rank != WinningRank.NO_PRIZE) {
                System.out.printf("%d개 일치 (%d원) - %d개%n",
                        rank.getRequiredMatchingCount(),
                        rank.getPrizeAmount(),
                        winningCounts.getOrDefault(rank, 0));
            }
        }
    }
}
