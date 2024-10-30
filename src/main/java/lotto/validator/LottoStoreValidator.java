package lotto.validator;

import lotto.constants.LottoValue;

public class LottoStoreValidator {
    private static final String ERROR_LOTTO_PRICE = "구입 금액은 1000원 단위로 입력해야 합니다.";

    public static void validatePurchaseAmount(int price){
        if (price % LottoValue.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ERROR_LOTTO_PRICE);
        }

    }
}
