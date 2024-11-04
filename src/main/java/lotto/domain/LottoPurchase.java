package lotto.domain;

public class LottoPurchase {

    private static final int LOTTO_PER_PRICE = 1000;

    private final int amount;

    public LottoPurchase(int amount) {
        validateMinAmount(amount);
        validateUnit(amount);
        this.amount = amount;
    }

    private static void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위의 숫자여야 합니다.");
        }
    }

    private static void validateMinAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 999원 보다 큰 숫자여야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return amount / LOTTO_PER_PRICE;
    }
}
