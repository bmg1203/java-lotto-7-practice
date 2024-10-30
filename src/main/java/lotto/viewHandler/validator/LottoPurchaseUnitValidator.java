package lotto.viewHandler.validator;

import lotto.viewHandler.exception.NotUnitPurchaseMoney;
import lotto.viewHandler.Validator;

import static lotto.viewHandler.exception.Util.MONEY_UNIT;
import static lotto.viewHandler.exception.Util.NOT_MONEY_UNIT;
import static lotto.viewHandler.exception.Util.ZERO;

public class LottoPurchaseUnitValidator implements Validator<Void, Integer> {
    @Override
    public Void validate(Integer getPurchase) {
        if(getPurchase % MONEY_UNIT != ZERO) {
            throw new NotUnitPurchaseMoney(NOT_MONEY_UNIT);
        }
        return null;
    }
}
