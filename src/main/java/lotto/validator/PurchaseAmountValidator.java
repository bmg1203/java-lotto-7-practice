package lotto.validator;

public class PurchaseAmountValidator {

    public static final int PURCHASE_UNIT = 1000;
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String EMPTY_INPUT_ERROR = ERROR_PREFIX + "로또 구입 금액을 입력해주세요.";
    public static final String NON_INTEGER_ERROR = ERROR_PREFIX + "%s: 정수값이 아닙니다.";
    public static final String OVERFLOW_ERROR = ERROR_PREFIX + "%s: 너무 큰 값을 입력하였습니다.";
    public static final String NOT_MULTIPLE_OF_THOUSAND_ERROR = ERROR_PREFIX + "로또 구입 금액은 1,000원 단위로 입력해 주세요.";

    public void validatePurchaseAmount(String beforePurchaseAmount) {
        validateEmptyString(beforePurchaseAmount);
        validateIntegerInput(beforePurchaseAmount);
        int purchaseAmount = validateIntegerRange(beforePurchaseAmount);
        validateNotMultipleOfThousand(purchaseAmount);
    }

    private void validateEmptyString(String beforePurchaseAmount) {
        if (beforePurchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private void validateIntegerInput(String beforePurchaseAmount) {
        try {
            Long.parseLong(beforePurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NON_INTEGER_ERROR, beforePurchaseAmount));
        }
    }

    private int validateIntegerRange(String beforePurchaseAmount) {
        long longValue = Long.parseLong(beforePurchaseAmount);
        if ( longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(String.format(OVERFLOW_ERROR, longValue));
        }
        return Integer.parseInt(beforePurchaseAmount);
    }

    private void validateNotMultipleOfThousand(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND_ERROR);
        }
    }

}
