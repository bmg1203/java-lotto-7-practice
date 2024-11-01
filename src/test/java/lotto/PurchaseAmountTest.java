package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @Test
    void PurchaseAmount_생성() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1_000);
        assertThat(purchaseAmount).isEqualTo(new PurchaseAmount(1_000));
    }

    @Test
    void 구매금액이_1000원으로_나누어_떨어지지_않으면_예외() {
        assertThatThrownBy(() -> new PurchaseAmount(1_500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNDIVIDED_THOUSAND);
    }
}
