package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountTest {

    @DisplayName("금액이 100으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "2500", "1001"})
    void 금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다(String inputAmount) {
        assertThatThrownBy(() -> Amount.of(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("금액이 1000원 미만이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "500", "999", "-1", "-1000"})
    void 금액이_1000원_미만이면_예외가_발생한다(String inputAmount) {
        assertThatThrownBy(() -> Amount.of(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
    }

    @DisplayName("금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "def", "ghi", "", " ", "1.5"})
    void 금액이_숫자가_아니면_예외가_발생한다(String inputAmount) {
        assertThatThrownBy(() -> Amount.of(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 자연수여야 합니다.");
    }

}
