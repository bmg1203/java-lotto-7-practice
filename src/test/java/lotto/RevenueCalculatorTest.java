package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class RevenueCalculatorTest {

    @AfterEach
    void 테스트_후_당첨_현황_초기화() {
        Arrays.stream(WinningRank.values()).forEach(WinningRank::resetSuccessMatch);
    }

    @Test
    void 최종_수익률_소수점_둘째자리까지_계산() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
        WinningRank.match(3, false);

        assertThat(RevenueCalculator.calculateRevenue(purchaseAmount)).isEqualTo(62.5);
    }
}
