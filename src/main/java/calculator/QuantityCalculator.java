package calculator;

import constant.ErrorConst;

public class QuantityCalculator {

    private static final int PRICE_MIN_INPUT = 1000;
    private static final long PRICE_MAX_INPUT = 4611686018000L ;


    public static long calculateBuyQuantity(long buyPrice) {
        checkPriceInputRange(buyPrice);
        return validateCanBeDivided(buyPrice);
    }


    private static long validateCanBeDivided(long buyPrice) {
        if (buyPrice % PRICE_MIN_INPUT != 0 ) {
            throw new IllegalArgumentException(ErrorConst.ERROR_INVALID_AMOUNT);
        }
        return buyPrice / PRICE_MIN_INPUT;
    }


    private static boolean checkPriceInputRange(long buyPrice){
        if(buyPrice <=0 ||buyPrice>PRICE_MAX_INPUT ){
            throw new IllegalArgumentException(ErrorConst.ERROR_NOT_AVAILABLE_RANGE );
        }
        return true;
    }
}
