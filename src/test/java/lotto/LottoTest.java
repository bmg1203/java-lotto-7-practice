package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void 로또번호_개수가_맞지_않으면_예외발생() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5); // NUMBER_COUNT가 6이라 가정
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(invalidNumbers);
        });
        assertThat(exception.getMessage()).contains("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또번호에_중복이_있으면_예외발생() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 5); // 중복된 숫자
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(invalidNumbers);
        });
        assertThat(exception.getMessage()).contains("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
    }

    @Test
    void 유효한_로또번호_입력시_성공() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertThat(lotto.getNumbers()).isEqualTo(validNumbers);
    }
}
