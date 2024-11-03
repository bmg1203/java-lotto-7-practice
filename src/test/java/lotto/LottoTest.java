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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 보너스_번호에_중복된_숫자가_있으면_예외가_발생한다(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.setBonusNumber(5))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 및 보너스 번호 숫자의 범위가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호_및_보너스_번호_숫자의_범위가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
            .isInstanceOf(IllegalArgumentException.class);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.setBonusNumber(46))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotto.setBonusNumber(0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
