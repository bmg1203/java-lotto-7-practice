package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidPurchaseAmountException;

public class InputService {
    private static final String CONVERT_ERROR_MESSAGE = "[ERROR] 잘못된 입력값입니다. 입력값은 숫자여야합니다.";
    private static final String AMOUNT_ERROR_MESSAGE = "[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.";

    public int purchaseValue() {
        String value = Console.readLine();
        return validatePurchaseValue(value);
    }

    public int validatePurchaseValue(String value) {
        int convertValue = convertToInt(value);

        if (convertValue % 1000 != 0) {
            throw new InvalidPurchaseAmountException(AMOUNT_ERROR_MESSAGE);
        }
        return convertValue;
    }

    public int convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            System.out.println(CONVERT_ERROR_MESSAGE);
            throw new IllegalArgumentException(CONVERT_ERROR_MESSAGE);
        }
    }
}
