package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoGameDisplay {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine();

        return Integer.parseInt(rawMoney);
    }

    public List<Integer> inputWinnerNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String numberMass = Console.readLine();
        String[] rawNumbers = numberMass.split(",");

        return Arrays.stream(rawNumbers)
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonusNumber(List<Integer> winnerNumbers) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String rawBonusNumber = Console.readLine();

        return Integer.parseInt(rawBonusNumber);
    }

    public void printPurchaseBreakdown(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = lotto.getNumbers();

        sb.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            sb.append(numbers.get(i).toString());
            sb.append(", ");
        }
        sb.append(numbers.getLast());
        sb.append("]");

        System.out.println(sb);
    }

    public void printWinStatistics(Map<LottoRank, Integer> rankMap, double rateOfResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        printRankBreakdown(rankMap);
        printRateOfResult(rateOfResult);
    }

    private void printRankBreakdown(Map<LottoRank, Integer> rankMap) {
        List<LottoRank> printLottoRanks = List.of(
                LottoRank.GRADE_5TH,
                LottoRank.GRADE_4TH,
                LottoRank.GRADE_3TH,
                LottoRank.GRADE_2TH,
                LottoRank.GRADE_1TH
        );

        for (LottoRank lottoRank : printLottoRanks) {
            System.out.printf("%s (%,d%s) - %d개\n",
                    lottoRank.getWinCondition(),
                    lottoRank.getPrizeMoney(),
                    LottoRank.UNIT,
                    rankMap.get(lottoRank)
            );
        }
    }

    private void printRateOfResult(double rateOfResult) {
        // 둘째자리에서 반올림하여 출력
        double result = Math.round(rateOfResult * 100) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", result);
    }
}
