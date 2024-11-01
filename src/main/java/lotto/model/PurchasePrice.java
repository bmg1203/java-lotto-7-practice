package lotto.model;

public class PurchasePrice {
    private static final String INVALID_PRICE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";

    private final int price;

    public PurchasePrice(int price) {
        validatePurchasePrice(price);
        this.price = price;
    }

    public static void validatePurchasePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_ERROR_MESSAGE);
        }
    }

    public int get() {
        return price;
    }
}
