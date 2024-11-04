package lotto.util;

import java.text.DecimalFormat;
import lotto.model.WinningDetails;

public class YieldCalculator {

    public static final int UNIT_PURCHASE_AMOUNT = 1000;
    public static final int PERCENTAGE_MULTIPLIER = 100;
    public static final String COMMA = ",";
    public static final String EMPTY_STRING = "";
    public static final int ZERO = 0;


    public String calculate(int lottoCount) {
        int totalPrize = getTotalPrize();
        int purchasedAmount = lottoCount * UNIT_PURCHASE_AMOUNT;

        double yield = (double) totalPrize / purchasedAmount * PERCENTAGE_MULTIPLIER;

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(yield);
    }

    private int getTotalPrize() {
        int totalPrize = ZERO;

        for (WinningDetails rank : WinningDetails.values()) {
            String processedWinningPrize = rank.getWinningPrize().replace(COMMA, EMPTY_STRING);
            int winningPrize = Integer.parseInt(processedWinningPrize);
            int matchLottoCount = rank.getMatchLottoCount();

            totalPrize += winningPrize * matchLottoCount;
        }
        return totalPrize;
    }
}
