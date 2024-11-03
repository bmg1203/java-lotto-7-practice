package lotto;

import lotto.domain.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {

    @DisplayName("구매 금액이 1000원 단위로 나누어 떨어지지 않으면 예외를 호출한다.")
    @Test
    void 구매_금액이_1000원_단위로_나누어_떨어지지_않으면_예외를_호출한다() {
        assertThatThrownBy(() -> new LottoPurchase(1001))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 10만원을 초과하는 경우 예외를 호출한다.")
    @Test
    void 구매_금액이_10만원을_초과하는_경우_예외를_호출한다() {
        assertThatThrownBy(() -> new LottoPurchase(101_000))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 미만일 경우 예외를 호출한다.")
    @Test
    void 구매_금액이_1000원_미만일_경우_예외를_호출한다() {
        org.junit.jupiter.api.Assertions.assertAll(
            () -> assertThatThrownBy(() -> new LottoPurchase(900))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new LottoPurchase(-2))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
