package lotto.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 구입금액에_공백이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "1,2,3,,4,5"})
    void 당첨번호에_공백이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 보너스_번호에_공백이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}