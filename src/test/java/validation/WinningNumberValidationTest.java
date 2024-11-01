package validation;

import lotto.validation.WinningNumberValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;


public class WinningNumberValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,1", "a,b,c,d,e,f"})
    @NullAndEmptySource
    @DisplayName("구매 금액이 null이거나 빈 값, 또는 문자가 입력될 때 예외 처리")
    void NullOrEmptyOrStringWinningNumberTest(String input) {
        assertThatThrownBy(() -> {
            WinningNumberValidation.parseValidatedWinningNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    @DisplayName("입력된 숫자가 6개가 아닐 때 예외 처리")
    void InvalidWinningNumberSizeTest(String input) {
        assertThatThrownBy(() -> {
            WinningNumberValidation.parseValidatedWinningNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3,4,5,6", "1,2,3,4,5,66"})
    @DisplayName("입력된 숫자가 1~45사이의 숫자가 아닐 때 예외 처리")
    void InvalidWinningNumberRangeTest(String input) {
        assertThatThrownBy(() -> {
            WinningNumberValidation.parseValidatedWinningNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,  2, 3,,4,5,6"})
    @DisplayName("공백이 있어도 유효한 숫자면 예외를 발생시키지 않는다.")
    void ValidWinningNumberLengthTest(String input) {
        assertThatNoException().isThrownBy(() -> {
            WinningNumberValidation.parseValidatedWinningNumber(input);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"0", "46", "abc"})
    @DisplayName("보너스 번호가 null이나 빈 값이거나, 범위를 넘거나, 숫자가 아닌 경우 예외 발생")
    void InvalidBonusNumberTest(String input) {
        assertThatThrownBy(() -> {
            WinningNumberValidation.parseValidatedBonusNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }


}
