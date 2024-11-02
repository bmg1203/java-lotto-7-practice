package lotto;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


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
    @DisplayName("당첨 등수가 0~5 범위에 해당하는 숫자가 아니면 예외가 발생한다")
    void failSetPrizeTierTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(()-> lotto.setPrizeTier(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> lotto.setPrizeTier(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 등수가 0~5 범위의 정수일 경우 등수 필드에 저장된다")
    void passSetPrizeTierTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.setPrizeTier(0);

        assertThat(lotto.getPrizeTier()).isEqualTo(0);
    }



}
