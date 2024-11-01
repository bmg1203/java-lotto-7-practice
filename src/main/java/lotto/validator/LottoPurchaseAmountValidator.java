package lotto.validator;

public class LottoPurchaseAmountValidator {
    private static String LOTTO_PURCHASE_AMOUNT_REGEX = "^[0-9]+$";

    private LottoPurchaseAmountValidator() {
    }

    public static void validateLottoPurchaseAmount(String lottoPurchaseAmount) {
        checkIncludeSpecialCharacters(lottoPurchaseAmount);
    }

    private static void checkIncludeSpecialCharacters(String lottoPurchaseAmount) {
        if (!lottoPurchaseAmount.matches(LOTTO_PURCHASE_AMOUNT_REGEX)) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자로 입력해야 합니다.");
        }
    }
}
