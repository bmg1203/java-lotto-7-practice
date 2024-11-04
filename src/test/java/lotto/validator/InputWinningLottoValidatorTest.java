package lotto.validator;

import static lotto.exception.ExceptionErrorMessage.INPUT_BLANK_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.INPUT_MINUS_NUMBER_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.INPUT_NOT_DIGIT_OR_NOT_DELIMITER_MESSAGE;
import static lotto.exception.ExceptionErrorMessage.INPUT_ZERO_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputWinningLottoValidatorTest {
    private InputWinningLottoValidatior validator;

    @BeforeEach
    public void setUp() {
        validator = new InputWinningLottoValidatior();
    }

    @Test
    public void 당첨_번호_공백_입력_테스트() {
        String input = "   ";
        assertThatThrownBy(() -> validator.isValidBeforeParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_BLANK_MESSAGE.toString());
    }


    @Test
    public void 당첨_번호_음수_입력_테스트() {
        String input = "-1";
        assertThatThrownBy(() -> validator.isValidAfterParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MINUS_NUMBER_MESSAGE.toString());
    }

    @Test
    public void 당첨_번호_0_입력_테스트() {
        String input = "0";
        assertThatThrownBy(() -> validator.isValidAfterParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_ZERO_NUMBER_MESSAGE.toString());
    }

    @Test
    public void 당첨_번호_숫자가_아닌_문자_입력_테스트() {
        String input = "1a";
        assertThatThrownBy(() -> validator.isValidAfterParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_NOT_DIGIT_OR_NOT_DELIMITER_MESSAGE.toString());
    }

    @Test
    public void null_입력_테스트() {
        assertThat(validator.isBlank(null)).isTrue();
    }
}