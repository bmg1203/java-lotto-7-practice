package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("당첨 번호는 6개의 숫자이다.")
    @Test
    void 당첨_번호는_6개의_숫자이다() {
        assertDoesNotThrow(() -> WinningNumber.from("1,2,3,4,5,6"));
    }

    @DisplayName("당첨 번호가 6개 미만일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개_미만일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개를 초과할 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개를_초과할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,6,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 숫자 범위는 1~45이다.")
    @Test
    void 당첨_번호의_숫자_범위는_1에서_45이다() {
        assertDoesNotThrow(() -> WinningNumber.from("1,5,15,25,35,45"));
    }

    @DisplayName("당첨 번호의 숫자가 1 미만일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_숫자가_1_미만일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumber.from("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);


        assertThatThrownBy(() -> WinningNumber.from("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 숫자가 45를 초과할 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_숫자가_45를_초과할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,200000000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 쉼표(,)를 기준으로 구분한다.")
    @Test
    void 당첨_번호는_쉼표를_기준으로_구분한다() {
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");

        List<Integer> numbers = winningNumber.getNumbers();

        assertIterableEquals(List.of(1, 2, 3, 4, 5, 6), numbers);
    }

    @DisplayName("쉼표(,) 사이에 아무 숫자가 없을 경우 예외가 발생한다.")
    @Test
    void 쉼표_사이에_아무_숫자가_없을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumber.from(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> WinningNumber.from("1,,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,6,,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자와 쉼표를 제외한 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_숫자와_쉼표를_제외한_문자가_입력될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumber.from("1, 2, 3, 4, 5, 45"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumber.from("*,2,3,4,5,45"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumber.from("1*2*3*4*5*45"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호가 null일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_null일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumber.from(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
