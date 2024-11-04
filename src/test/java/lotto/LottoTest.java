package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))  // 0은 유효 범위를 벗어남
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))  // 46은 유효 범위를 벗어남
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
    }

    @DisplayName("로또 번호 리스트가 null이면 예외가 발생한다.")
    @Test
    void 로또_번호_리스트가_null_이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호 리스트는 null일 수 없습니다.");
    }
}
