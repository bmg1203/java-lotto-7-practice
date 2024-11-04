package calculator;

import constant.ErrorConst;

public class QuantityCalculator {

    private static final int PRICE_UNIT = 1000;


    public static int calculateBuyQuantity(int buyPrice) {
        isPositivePrice(buyPrice);
        return validateCanBeDivided(buyPrice);
    }


    private static int validateCanBeDivided(int buyPrice) {
        if (buyPrice % PRICE_UNIT != 0 ) {
            throw new IllegalArgumentException(ErrorConst.ERROR_INVALID_AMOUNT);
        }
        return buyPrice / PRICE_UNIT;
    }

    private static boolean isPositivePrice(int buyPrice){
        if(buyPrice <=0){
            throw new IllegalArgumentException(ErrorConst.ERROR_NEGATIVE_AMOUNT );
        }
        return true;
    }
}
