package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import lotto.domain.Lottos;

import javax.xml.transform.stream.StreamSource;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public static void printPurchasedLottos(Lottos purchasedLottos) {
        String output = purchasedLottos.getLottoCount() + "개를 구매했습니다.\n" +
                purchasedLottos.getLottos().stream()
                                .map(lotto -> lotto.getNumbers().toString())
                                        .collect(Collectors.joining("\n"));

        System.out.println(output);
    }

    public static void printResult(LottoRanks lottoRanks) {
        System.out.println("당첨 통계\n---\n");
        for(LottoRank lottoRank : lottoRanks.getRanks()) {
            System.out.printf(
                    "%d개 일치 (%,d원) - %d개%n",
                    lottoRank.getRequiredMatchCount(),
                    lottoRank.getPrize(),
                    lottoRank.getWinningCount()
            );
        }
    }
}
