package lotto.model.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Assertions;
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

    @Test
    public void 로또_번호의_범위를_벗어나면_예외가_발생한다() throws Exception {
        //given
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 46);
        List<Integer> list2 = List.of(1, 2, 3, 4, 5, -1);

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(list1),
                ErrorMessage.LOTTO_NUMBER_RANGE_VALIDATOR.getMessage());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(list2),
                ErrorMessage.LOTTO_NUMBER_RANGE_VALIDATOR.getMessage());
    }
}