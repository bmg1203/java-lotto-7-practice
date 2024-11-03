package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Result;

import java.util.Arrays;

import static lotto.message.InfoMessage.*;

public class OutputView {
    public static void showLottosInfo(Lottos lottos){
        long lottoCount = lottos.getLottoCount();
        System.out.println(LOTTO_COUNT_INFO.formatNumber(lottoCount));
        lottos.showInfo();
    }

    public static void showResult() {
        System.out.println(WINNING_STATS_LABEL.getMessage());
        Arrays.stream(Result.values())
                .filter(result -> result.print)
                .map(Result::getMessage)
                .forEach(System.out::println);
    }

    public static void showProfitRate(long lottoCount, long profitSum) {
        double profitRate = profitSum / (lottoCount * 10.0);
        System.out.println(PROFIT_RATE_INFO.formatProfit(profitRate));
    }
}
