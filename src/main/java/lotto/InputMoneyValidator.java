package lotto;

import java.util.regex.Pattern;

public class InputMoneyValidator {
    private static final String MONEY_REGEX_PATTERN = "\\d+";


    public void validate(String money) {
        validateNumber(money);
        validateTicketPrice(money);
    }

    public void validateNumber(String money) {
        if (!Pattern.matches(MONEY_REGEX_PATTERN, money)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateTicketPrice(String money) {
        if (Integer.parseInt(money)%1000 > 0 || Integer.parseInt(money)/1000 < 0) {
            throw new IllegalArgumentException();
        }
    }

}
