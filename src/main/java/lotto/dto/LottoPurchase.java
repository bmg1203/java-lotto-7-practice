package lotto.dto;

import lotto.validator.LottoPurchaseValidator;

public record LottoPurchase(int amount) {
    public LottoPurchase {
        LottoPurchaseValidator.validateAmount(amount);
    }
}