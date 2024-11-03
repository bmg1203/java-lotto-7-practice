package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_1부터_45사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 47, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 구입 금액이 1,000원 으로 나누어 떨어 지지 않는 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Money.validate("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 입력_금액이_숫자가_아닐경우_예외발생() {
        assertThatThrownBy(() -> Money.validate("ㄱㄴㄷㄹ"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
