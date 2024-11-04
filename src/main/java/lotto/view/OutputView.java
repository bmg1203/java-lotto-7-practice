package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.constant.PurchaseOutputMessage;
import lotto.constant.StatisticsOutputMessage;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {
    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.printf(PurchaseOutputMessage.NUMBER_OF_PURCHASED_LOTTO.getMessage(), purchasedLotto.size());
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoResults(Map<Rank, Integer> results) {
        System.out.println(StatisticsOutputMessage.START_COMMENT.getMessage());
        System.out.println(StatisticsOutputMessage.START_LINE.getMessage());

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            int count = results.getOrDefault(rank, 0);
            String formattedPrize = numberFormat.format(rank.getPrizeMoney());

            if (rank == Rank.SECOND) {
                System.out.printf(StatisticsOutputMessage.CONTENT_OF_RESULT_FOR_BONUS_NUMBER.getMessage(),
                        rank.getMatchCount(), formattedPrize, count);
            } else {
                System.out.printf(StatisticsOutputMessage.CONTENT_OF_LOTTO_RESULT.getMessage(),
                        rank.getMatchCount(), formattedPrize, count);
            }
            System.out.println();
        }
    }
}