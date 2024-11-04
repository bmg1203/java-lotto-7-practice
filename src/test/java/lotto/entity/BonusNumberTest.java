package lotto.entity;

import lotto.enums.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest {
    private static final String TEST_TITLE_HEADER = "[BonusNumberTest] ";

    @DisplayName(TEST_TITLE_HEADER + "보너스 번호에 빈 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @NullSource
    void 보너스_번호에_빈_값이_입력되면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_IS_NULL.getMessage());
    }

    @DisplayName(TEST_TITLE_HEADER + "보너스 번호에 숫자 외의 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"-123", "asdwasda", "*@^&*@$", "12@*#", "asd12@$#", "12 21141 13", "123,123,43,12,1"})
    void 보너스_번호에_숫자_외의_값이_입력되면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_NOT_VALID_FORMAT.getMessage());
    }

    @DisplayName(TEST_TITLE_HEADER + "보너스 번호가 1 과 45 사이의 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "2341412"})
    void 보너스_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName(TEST_TITLE_HEADER + "정상 동작 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "13", "45", "23"})
    void 정상_동작_테스트(String input) {
        assertThat(new BonusNumber(input).getValue()).isEqualTo(Integer.parseInt(input));
    }
}
