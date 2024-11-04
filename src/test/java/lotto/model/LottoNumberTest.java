package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessages;
import lotto.model.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 1~45 범위이면 정상 생성된다.")
    void testValidLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber("1");
        assertThat(lottoNumber.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호가 빈 공백이면 예외를 던진다.")
    void testBlankInputThrowsException() {
        assertThatThrownBy(() -> new LottoNumber("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("로또 번호가 특수문자이면 예외를 던진다.")
    void testSpecialCharacterInputThrowsException() {
        assertThatThrownBy(() -> new LottoNumber("#@"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("로또 번호가 음수이면 예외를 던진다.")
    void testNegativeNumberThrowsException() {
        assertThatThrownBy(() -> new LottoNumber("-12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("로또 번호가 0이면 예외를 던진다.")
    void testZeroNumberThrowsException() {
        assertThatThrownBy(() -> new LottoNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위가 아니면 예외를 던진다.")
    void testOutOfRangeNumberThrowsException() {
        assertThatThrownBy(() -> new LottoNumber("100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_LOTTO_NUMBER);
    }
}