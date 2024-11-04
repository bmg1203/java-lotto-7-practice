package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 유효한 범위가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_유효한_범위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 11, 21, 23, 43, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 입력하지 않으면 예외가 발생한다.")
    @Test
    void 로또_번호를_입력하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 유효한 구분자로 구분하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.2,3,4,5,6", "1.2.3.4.5.6", "1,2,3.4,5,6"})
    void 로또_번호를_유효한_구분자로_구분하지_않으면_예외가_발생한다(String numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
