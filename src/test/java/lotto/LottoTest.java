package lotto;

import static lotto.common.exception.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.common.exception.ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_한_장은_중복되지_않는_6개의_번호로_구성된다() {
        // given
        List<LottoNumber> numbers = List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );

        // when
        Lotto lotto = Lotto.from(numbers);

        // then
        assertEquals(lotto.numbers(), numbers);
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // given
        List<LottoNumber> numbers = List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
                LottoNumber.from(7)
        );

        // when & then
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_COUNT_ERROR.message());
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<LottoNumber> numbers = List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(5)
        );

        // when & then
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DUPLICATION_ERROR.message());
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
