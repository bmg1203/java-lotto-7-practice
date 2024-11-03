package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 로또_번호의_개수가_6개_미달이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정렬된_번호_반환_테스트() {
        // given : 정렬되지 않은 숫자 리스트로 Lotto 객체 생성
        List<Integer> numbers = List.of(5, 3, 6, 1, 4, 2);
        Lotto lotto = new Lotto(numbers);

        // when : sortedNumbers 호출
        List<Integer> sortedNumbers = lotto.sortedNumbers();

        // then : 오름차순으로 정렬되어있는지 확인
        assertThat(sortedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

}
