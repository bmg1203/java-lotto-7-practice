package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLottos;
import lotto.global.LottoRank;

public class OutputView {

    public static final String LOTTO_PRINT_MESSAGE = "개를 구매했습니다.";
    public static final String RESULT_START_MESSAGE = "당첨 통계\n---";
    public static final String LOTTO_NUMBER_DELIMITER = ",";

    public static final String LOTTO_DISPLAY_FORMAT = "[%s]\n";
    public static final String RESULT_DISPLAY_FORMAT = " - [%S]개\n";
    public static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public static void printLottos(Lottos lottos) {
        System.out.print(lottos.getLottos().size());
        System.out.println(LOTTO_PRINT_MESSAGE);
        lottos.getLottos()
                .forEach(OutputView::printLotto);
    }

    public static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));

        System.out.printf(LOTTO_DISPLAY_FORMAT,result);
    }

    public static void printResult(WinningLottos winningLottos) {
        System.out.println(RESULT_START_MESSAGE);

        for (LottoRank rank : LottoRank.values()) {
            System.out.print(rank.toString());
            System.out.printf(RESULT_DISPLAY_FORMAT,winningLottos.getWinningCountByLottoRank(rank));
        }

        System.out.printf(PROFIT_RATE_FORMAT,winningLottos.getProfitRate());
    }
}
