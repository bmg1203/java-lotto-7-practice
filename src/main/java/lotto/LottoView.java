package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.stream.Collectors;

public class LottoView {

    public static int getInputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void printLottos(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String lottoFormat = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoFormat);
        }
    }

    public static void printLottoResult(Map<LottoRank, Integer> rankCount) {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {

            if (rank == LottoRank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                        rank.getMatchCount(),
                        String.format("%,d", rank.getPrize()),
                        rankCount.get(rank));
                continue;
            }

            System.out.printf("%d개 일치 (%s원) - %d개%n",
                    rank.getMatchCount(),
                    String.format("%,d", rank.getPrize()),
                    rankCount.get(rank));

        }
    }

    public static void printReturnRate(int totalPrize, int inputCash) {
        System.out.printf("총 수익률은 %.1f%%입니다.", (double) totalPrize / inputCash * 100);
    }
}
