package lotto.application.validation;

import static lotto.infrastructure.exception.ErrorCode.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.application.validation.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 클래스 테스트")
public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 로또_구입_금액이_숫자가_아니라면_예외를_발생한다() {
        // given
        String purchaseAmount = "1000a";

        // when & then
        assertThatThrownBy(() -> inputValidator.validateAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    void 로또_구입_금액이_정수_범위를_벗어나면_예외를_발생한다() {
        // given
        String purchaseAmount = "21474836998";

        // when & then
        assertThatThrownBy(() -> inputValidator.validateAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    void 로또_번호에_구분자가_앞_뒤에_포함되어_있다면_예외를_발생한다() {
        // given
        String firstLottoNumbers = ",1,2,3,4,5,6";
        String secondLottoNumbers = "1,2,3,4,5,6,";

        // when & then
        assertThatThrownBy(() -> inputValidator.validateLotto(firstLottoNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_LOTTO_DELIMITER_POSITION.getMessage());

        assertThatThrownBy(() -> inputValidator.validateLotto(secondLottoNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_LOTTO_DELIMITER_POSITION.getMessage());
    }

    @Test
    void 로또_번호에_구분자가_연속으로_포함되어_있다면_예외를_발생한다() {
        // given
        String lottoNumbers = "1,,2,3,4,5,6";

        // when & then
        assertThatThrownBy(() -> inputValidator.validateLotto(lottoNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_LOTTO_CONSECUTIVE_DELIMITERS.getMessage());
    }
}
