package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    @DisplayName("로또 번호가 6개가 넘어가면 예외가 발생한다.")
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

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void 로또_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개보다 적으면 예외가 발생한다.")
    @Test
    void 로또_번호가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등 확인 테스트")
    @Test
    void 로또_1등_확인_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkRank(List.of(1, 2, 3, 4, 5, 6), 7)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("2등 확인 테스트")
    @Test
    void 로또_2등_확인_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkRank(List.of(1, 2, 3, 4, 5, 7), 6)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("3등 확인 테스트")
    @Test
    void 로또_3등_확인_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkRank(List.of(1, 2, 3, 4, 5, 7), 8)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4등 확인 테스트")
    @Test
    void 로또_4등_확인_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkRank(List.of(1, 2, 3, 4, 7, 8), 5)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("5등 확인 테스트")
    @Test
    void 로또_5등_확인_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkRank(List.of(1, 2, 3, 7, 8, 9), 5)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("미당첨 확인 테스트")
    @Test
    void 로또_미당첨_확인_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkRank(List.of(7, 8, 9, 10, 11, 12), 5)).isEqualTo(LottoRank.NONE);
    }
}
