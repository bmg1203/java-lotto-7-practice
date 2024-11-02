package lotto.validator;

import lotto.constants.LottoValue;
import lotto.utils.ExceptionUtils;

import static lotto.constants.ErrorMessage.ERROR_LOTTO_PRICE;

public class LottoStoreValidator {

    public static void validatePurchaseAmount(final int price){
        if (price % LottoValue.LOTTO_PRICE.getValue() != 0) {
            ExceptionUtils.throwIllegalArgument(ERROR_LOTTO_PRICE.getMessage());
        }

    }
}
