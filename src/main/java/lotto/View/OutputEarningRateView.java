package lotto.View;

import java.text.DecimalFormat;

import static lotto.Utils.PrintConstants.OUTPUT_ERNING_RATE;

public class OutputEarningRateView {
    public void printEarningRate(double earningRate) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.#");
        System.out.println(String.format(OUTPUT_ERNING_RATE, decimalFormat.format(Math.round(earningRate * 10) / 10.0)));
    }
}
