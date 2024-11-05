package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        //when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        //when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_로또_번호를_넣으면_객체가_만들어진다() {
        //when & then
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또_번호를_비교하면_동일한_숫자_개수가_반환된다() {
        //given
        final int expetedCount = 3;
        final Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto lotto2 = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        //when
        final int sameCount = lotto1.getSameCount(lotto2);

        //then
        assertThat(sameCount).isEqualTo(expetedCount);
    }
}
