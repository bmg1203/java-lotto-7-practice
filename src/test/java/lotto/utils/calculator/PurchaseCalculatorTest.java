package lotto.utils.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import lotto.utils.Calculator.PurchaseCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseCalculatorTest {

    @Test
    @DisplayName("정상 금액 로또 수 계산 검증")
    void givenValidMoney_whenCalculateLottoCount_thenReturnsCorrectCount() {
        // given
        Money money = new Money(5000);

        // when
        int lottoCount = PurchaseCalculator.calculateLottoCount(money);

        // Then
        assertThat(lottoCount).isEqualTo(5);
    }
}
