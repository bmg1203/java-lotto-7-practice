package lotto;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("로또 번호가 6개이고 1~45 범위의 고유 숫자로 이루어졌을 때 정상적으로 생성된다.")
    void 로또_번호가_정상적으로_생성된다() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(8, 21, 23, 41, 42, 43);
    }
    @Test
    @DisplayName("당첨 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    void 당첨번호_범위_검증() {
        assertThatThrownBy(() -> new Winning(new int[]{0,2,3,4,5,6}, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> new Winning(new int[]{1,2,3,4,5,46}, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    void 보너스번호_범위_검증() {
        assertThatThrownBy(() -> new Winning(new int[] {1,2,3,4,5,6}, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> new Winning(new int[] {1,2,3,4,5,6}, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void 보너스번호_중복_검증() {
        assertThatThrownBy(() -> new Winning(new int[]{1,2,3,4,5,6}, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
