package lotto.view;

import lotto.constant.CompareInteger;
import lotto.constant.LottoGuide;
import lotto.model.Consumer;
import lotto.model.Lotto;


public class OutputView {
    public static void printPriceGuide() {
        System.out.println(LottoGuide.PRICE_GUIDE.getMessage());
    }

    public static void printLottoTicket(Consumer consumer) {
        changeLine();
        printPurchaseCount(consumer.getLottoTicket().size());

        for (Lotto lotto : consumer.getLottoTicket()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printPurchaseCount(int count) {
        System.out.printf(LottoGuide.PURCHASE_COUNT.getMessage(), count);
    }

    public static void printWinningNumberGuide() {
        changeLine();
        System.out.println(LottoGuide.WINNING_NUMBER_GUIDE.getMessage());
    }

    public static void printBonusNumberGuide() {
        changeLine();
        System.out.println(LottoGuide.BONUS_NUMBER_GUIDE.getMessage());
    }

    private static void printResultGuide() {
        changeLine();
        System.out.println(LottoGuide.RESULT_GUIDE.getMessage());
        System.out.println(LottoGuide.LINE_SEPARATOR.getMessage());
    }

    public static void printResult(Consumer consumer) {
        printResultGuide();
        System.out.printf(LottoGuide.RESULT_FIFTH.getMessage(), consumer.getLottoResult()[3]);
        System.out.printf(LottoGuide.RESULT_FOURTH.getMessage(), consumer.getLottoResult()[4]);
        System.out.printf(LottoGuide.RESULT_THIRD.getMessage(), consumer.getLottoResult()[5] - consumer.getSecondPlace());
        System.out.printf(LottoGuide.RESULT_SECOND.getMessage(), consumer.getSecondPlace());
        System.out.printf(LottoGuide.RESULT_FIRST.getMessage(), consumer.getLottoResult()[6]);
        printEarningRate(consumer);
    }

    private static void printEarningRate(Consumer consumer) {
        double PERCENTAGE = 100.0;

        double price = CompareInteger.PRICE_LOTTO.getNumber() * consumer.getLottoTicket().size();

        double prize = consumer.getLottoResult()[3] * CompareInteger.PRIZE_FIFTH.getNumber();
        prize += consumer.getLottoResult()[4] * CompareInteger.PRIZE_FOURTH.getNumber();
        prize += (consumer.getLottoResult()[5] - consumer.getSecondPlace()) * CompareInteger.PRIZE_THIRD.getNumber();
        prize += consumer.getSecondPlace() * CompareInteger.PRIZE_SECOND.getNumber();
        prize += consumer.getLottoResult()[6] * CompareInteger.PRIZE_FIRST.getNumber();

        System.out.printf(LottoGuide.EARNING_RATE.getMessage(), prize / price * PERCENTAGE);
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    private static void changeLine() {
        System.out.println();
    }
}
