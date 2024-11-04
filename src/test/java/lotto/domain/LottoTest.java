package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

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

    @DisplayName("정상적인 로또 번호가 입력되었을 때 로또 객체가 생성된다.")
    @Test
    void 정상_로또_생성_테스트() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertEquals(validNumbers, lotto.getNumbers());
    }

    @DisplayName("로또 번호가 6개보다 적을 때 예외가 발생한다.")
    @Test
    void 로또_번호_갯수_예외_테스트() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers), "[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
