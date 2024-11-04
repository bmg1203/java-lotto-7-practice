package lotto.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.message.ExceptionMessage;

public class OutputView {
    public static final NumberFormat PROFIT_FORMAT = new DecimalFormat(OutputView.PROFIT_PATTERN);
    private static final String PROFIT_PATTERN = "#,###.0";
    public static final String REQUEST_PURCHASE_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String PURCHASED_LOTTOS = "개를 구매했습니다.";
    public static final String REQUEST_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String MATCH_COUNT_HEADER = "당첨 통계\n" + "---";
    public static final String MATCH_COUNT = "%s - %d개\n";
    public static final String PROFIT_RATE = "총 수익률은 %s%%입니다.";

    public static void printRequestPurchaseMoneyAmount() {
        printMessage(REQUEST_PURCHASE_MONEY_AMOUNT);
    }

    public static void printPurchasedLottos(int lottoCount, String purchasedLottos) {
        printMessage(lottoCount + PURCHASED_LOTTOS);
        printMessage(purchasedLottos);
    }

    public static void printRequestWinningLottoNumbers() {
        printMessage(REQUEST_WINNING_LOTTO_NUMBERS);
    }

    public static void printRequestBonusNumber() {
        printMessage(REQUEST_BONUS_NUMBER);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        printMessage(MATCH_COUNT_HEADER);
        printByRank(LottoRank.FIFTH, lottoResult.findCountByLottoRank(LottoRank.FIFTH));
        printByRank(LottoRank.FOURTH, lottoResult.findCountByLottoRank(LottoRank.FOURTH));
        printByRank(LottoRank.THIRD, lottoResult.findCountByLottoRank(LottoRank.THIRD));
        printByRank(LottoRank.SECOND, lottoResult.findCountByLottoRank(LottoRank.SECOND));
        printByRank(LottoRank.FIRST, lottoResult.findCountByLottoRank(LottoRank.FIRST));
        printProfitRate(lottoResult);
    }

    private static void printByRank(LottoRank rank, int count) {
        System.out.printf(MATCH_COUNT, rank.getMessage(), count);
    }

    private static void printProfitRate(LottoResult lottoResult) {
        double totalProfit = lottoResult.getTotalProfit();
        System.out.printf(PROFIT_RATE, PROFIT_FORMAT.format(totalProfit));
    }

    public static void printException(IllegalArgumentException e) {
        printMessage(ExceptionMessage.PREFIX + e.getMessage());
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }


}
