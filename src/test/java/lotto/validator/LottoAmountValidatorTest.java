package lotto.validator;

import static lotto.exception.Exception.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAmountValidatorTest {
    @DisplayName("구입 금액이 음수이거나 0일 경우의 예외 테스트")
    @Test
    void purchaseAmountNotPositive() {
        assertThatThrownBy(() -> LottoAmountValidator.validate(-1000, 1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_MUST_BE_POSITIVE.getMessage());
    }
}