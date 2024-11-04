package lotto.domain.amount;

import static lotto.infrastructure.exception.ErrorCode.*;

public class PurchaseAmount extends Amount {

    private static final int MINIMUM_AMOUNT_CRITERION = 1000;
    private final int LOTTO_COST_CRITERION = 1000;

    private PurchaseAmount(int amount) {
        super(amount);
    }

    public static PurchaseAmount from(int amount) {
        validateDividedByProperUnit(amount);
        validateProperAmount(amount);

        return new PurchaseAmount(amount);
    }

    private static void validateProperAmount(int amount) {
        if (amount < MINIMUM_AMOUNT_CRITERION) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateDividedByProperUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public boolean isEnough() {
        return this.amount >= MINIMUM_AMOUNT_CRITERION;
    }

    public void deduct() {
        if (!isEnough()) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
        this.amount -= LOTTO_COST_CRITERION;
    }
}
