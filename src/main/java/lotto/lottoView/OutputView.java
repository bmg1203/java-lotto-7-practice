package lotto.lottoView;

import java.util.Arrays;
import java.util.List;
import lotto.LottoPrize;
import lotto.lottoModel.LottoDTO;
import lotto.lottoModel.StatisticsLottoDTO;

public class OutputView {
    private static final String HOW_MANY_BUY = "%d개를 구매했습니다.";
    private static final String STATISTIC_START = "당첨 통계\n---";
    private static final String VALUE_MATCH_START = "%d개 일치";
    private static final String VALUE_MATCH_END = " (%,d원) - %d개";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";


    public void howManyBuy(String numberOfBuy) {
        System.out.println();
        System.out.printf(HOW_MANY_BUY, (Long.parseLong(numberOfBuy) / 1000));
        System.out.println();
    }

    public void printLottoNumbers(List<LottoDTO> allLottosAsDTO) {
        for (LottoDTO dto : allLottosAsDTO) {
            List<Integer> oneLotto = dto.getNumbers();
            Arrays.sort(new List[]{oneLotto});
            System.out.println(oneLotto);
        }
    }


    public void statisticStart(StatisticsLottoDTO stats) {
        System.out.println();
        System.out.println(STATISTIC_START);
        for (int i = 3; i <= 6; i++) {
            statisticEnd(i, stats);
        }
    }

    public void statisticEnd(int i, StatisticsLottoDTO stats) {
        if (i == 5) { // 맞춘 개수가 5개일 때
            System.out.printf(VALUE_MATCH_START + VALUE_MATCH_END, i, LottoPrize.getPrize(i, false),
                    stats.getHitNumberValue(i) - stats.getBonusNumberFrequency()); // 그냥 5개인 경우
            System.out.println();
            System.out.printf(VALUE_MATCH_START + BONUS_MATCH + VALUE_MATCH_END, i, LottoPrize.getPrize(i, true),
                    stats.getBonusNumberFrequency()); // 보너스 5개인 경우
            System.out.println();
            return;
        }
        System.out.printf(VALUE_MATCH_START + VALUE_MATCH_END, i, LottoPrize.getPrize(i, false),
                stats.getHitNumberValue(i));
        System.out.println();
    }

    public void profitMessage(double profit) {
        System.out.printf(PROFIT_MESSAGE, profit);
    }


}
