package lotto.util;

import static lotto.constants.NumberConstants.MONEY_UNIT;
import static lotto.constants.NumberConstants.ZERO;
import static lotto.constants.RegExpConstants.INT_REGEX;
import static lotto.message.ErrorMessage.INVALID_MONEY_TYPE;

public class MoneyValidator {

    public static int validate(final String moneyTemp) {
        intValidate(moneyTemp);
        int money = Integer.parseInt(moneyTemp);
        unitValidate(money);
        return money;
    }

    private static void intValidate(String moneyTemp) {
        if (!moneyTemp.matches(INT_REGEX)) {
            throw new IllegalArgumentException(INVALID_MONEY_TYPE.getMessage());
        }
    }

    private static void unitValidate(int money) {
        if (money == ZERO || money % MONEY_UNIT != ZERO) {
            throw new IllegalArgumentException(INVALID_MONEY_TYPE.getMessage());
        }
    }

}
