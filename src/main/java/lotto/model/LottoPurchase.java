package lotto.model;

import lotto.constant.ErrorConstant;

public class LottoPurchase {

    private static final long LOTTO_PRICE = 1_000L;

    private final long price;

    private LottoPurchase(final long price) {
        this.price = price;
    }

    public static LottoPurchase from(final String input) {
        long price = convertToNumber(input);
        return new LottoPurchase(price);
    }

    private static long convertToNumber(final String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ErrorConstant.ERROR.getContent() + " 잘못된 숫자 입력입니다.");
        }
    }

    public long getPrice() {
        return price;
    }

    public long getLottoCount() {
        return price / LOTTO_PRICE;
    }
}
