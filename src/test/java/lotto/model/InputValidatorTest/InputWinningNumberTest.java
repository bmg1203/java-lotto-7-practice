package lotto.model.InputValidatorTest;

import lotto.model.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputWinningNumberTest {
    private InputValidator inputValidator;

    @BeforeEach
    public void setup() {
        inputValidator = new InputValidator();
    }

    @DisplayName("당첨 번호가 6개가 아닐 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"'1'", "'1,2'", "'1,2,3'", "'1,2,3,4'", "'1,2,3,4,5'"})
    public void 당첨_번호가_6개가_아닐_경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복될 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"'1,2,2,3,4,5'", "'1,1,1,1,1,1'", "'29,30,31,32,33,30'"})
    public void 당첨_번호가_중복될_경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 범위가 1에서 45가 아닐 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"'0,2,3,5,46,99'", "'99,999,9999,99999,999999,9999999'"})
    public void 당첨_번호의_범위가_1에서_45가_아닐_경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 음수일 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"'-1,1,2,3,4,5'", "'-99,-8,-12,-20,-999'"})
    public void 당첨_번호가_음수일_경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자가 쉼표가 아니라면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1!2!3!4!5!6", "1-2-3-4-5-6"})
    public void 구분자가_쉼표가_아니라면_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 정수가 아닐경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"'a,b,c,d,e,f'", "'일번,이번,삼번,사번,오번,육번'", "'ㄱ,ㄴ,ㄷ,ㄹ,ㅁ,ㅂ'", "'1.0,2.0,3.0,4.0,5.0,6.0'"})
    public void 당첨_번호가_정수가_아닐경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
