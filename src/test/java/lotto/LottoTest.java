package lotto;

import static lotto.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).
                hasMessage(INVALID_LOTTO_NUMBER_COUNT);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void 로또_번호_범위_초과_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 47, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호_범위_미만_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 47, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE);
    }

}
