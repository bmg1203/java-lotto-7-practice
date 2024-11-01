package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinningLottoTest {
    @DisplayName("사용자 로또 번호와 당첨 번호의 일치 개수를 확인한다.")
    @Test
    void 맞춘_번호_개수_테스트() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        int matchingCount = winningLotto.countMatchingNumbers(userLotto);

        assertThat(matchingCount).isEqualTo(3);
    }

    @DisplayName("사용자 로또 번호에 보너스 번호가 포함되어 있는지 확인한다.")
    @Test
    void 보너스_번호_포함_여부_테스트() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto userLottoWithBonus = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto userLottoWithoutBonus = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        assertThat(winningLotto.containsBonusNumber(userLottoWithBonus)).isTrue();
        assertThat(winningLotto.containsBonusNumber(userLottoWithoutBonus)).isFalse();
    }

    @DisplayName("당첨 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호와_보너스_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위 외의 숫자면 예외가 발생한다.")
    @Test
    void 범위_외의_숫자_예외_테스트() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}