package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int purchaseAmount) {
        validateMinimumPurchaseAmount(purchaseAmount);
        validateDivisibility(purchaseAmount);
    }

    private void validateMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액은 0 이상이어야 합니다.");
        }
    }

    private void validateDivisibility(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매 금액은 " + LOTTO_PRICE + "원 단위여야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
