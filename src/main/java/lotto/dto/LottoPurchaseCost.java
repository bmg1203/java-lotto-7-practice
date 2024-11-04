package lotto.dto;

import static lotto.validator.LottoPurchaseCostValidator.validateLottoPurchaseCost;

public record LottoPurchaseCost(
        int amount
) {
    public static LottoPurchaseCost of(String inputLottoPurchaseCost) {
        validateLottoPurchaseCost(inputLottoPurchaseCost);
        return new LottoPurchaseCost(Integer.parseInt(inputLottoPurchaseCost));
    }
}
