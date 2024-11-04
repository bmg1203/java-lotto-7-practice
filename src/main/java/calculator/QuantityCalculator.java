package calculator;

import constant.ErrorConst;

public class QuantityCalculator {

    private static final int PRICE_UNIT = 1000;


    public static int calculateBuyQuantity(int buyPrice) {
        return validateCanBeDivided(buyPrice);
    }


    private static int validateCanBeDivided(int buyPrice) {
        if (buyPrice % PRICE_UNIT != 0 || buyPrice ==0) {
            throw new IllegalArgumentException(ErrorConst.ERROR_INVALID_AMOUNT);
        }
        return buyPrice / PRICE_UNIT;
    }
}
