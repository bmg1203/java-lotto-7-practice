package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1과 45 사이의 값이 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_1과_45_사이의_값이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(0, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_조건을_만족할_때_올바르게_생성된다() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        //when
        Lotto lotto = Lotto.from(numbers);

        //Then
        assertThat(lotto).isNotNull();
        assertThat(lotto.numbers()).hasSize(6);
    }
}
