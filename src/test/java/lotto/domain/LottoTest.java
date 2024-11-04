package lotto.domain;

import lotto.LottoNumbersTestCase;
import lotto.global.common.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final int bonus = 7;

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


    @ParameterizedTest
    @EnumSource(value = LottoNumbersTestCase.class)
    void 당첨_여부_확인(LottoNumbersTestCase testCase) {
        //given
        Lotto lotto = new Lotto(testCase.numbers);

        //when
        Rank check = lotto.check(winningLotto, bonus);

        //then
        assertThat(check).isInstanceOf(Rank.class);
        assertThat(check).isEqualTo(testCase.rank);
    }
}
