package lotto.entity;

import static lotto.exception.WinnerNumberExceptionMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.WinnerNumberExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 40;

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(integers, bonusNumber));

        // then
        assertEquals(LottoExceptionMessage.INVALID_NUMBER_COUNT.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 40;

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(integers, bonusNumber));

        // then
        assertEquals(LottoExceptionMessage.DUPLICATE_NUMBERS.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 로또_번호에_정해진_범위를_벗어나는_숫자가_있으면_예외가_발생한다_위로() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 46);
        int bonusNumber = 40;

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(integers, bonusNumber));

        // then
        assertEquals(LottoExceptionMessage.NUMBER_OUT_OF_RANGE.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 로또_번호에_정해진_범위를_벗어나는_숫자가_있으면_예외가_발생한다_아래로() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 0);
        int bonusNumber = 40;

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(integers, bonusNumber));

        // then
        assertEquals(LottoExceptionMessage.NUMBER_OUT_OF_RANGE.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 보너스_번호에_정해진_범위를_벗어나는_숫자가_있으면_예외가_발생한다_위로() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 40);
        int bonusNumber = 46;

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(integers, bonusNumber));

        // then
        assertEquals(BONUS_NUMBER_OUT_OF_RANGE.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 보너스_번호에_정해진_범위를_벗어나는_숫자가_있으면_예외가_발생한다_아래로() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 40);
        int bonusNumber = 0;

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(integers, bonusNumber));

        // then
        assertEquals(BONUS_NUMBER_OUT_OF_RANGE.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 당첨번호에_보너스_번호와_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 40);
        int bonusNumber = 40;

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(integers, bonusNumber));

        // then
        assertEquals(BONUS_NUMBER_DUPLICATE.getMessage(), illegalArgumentException.getMessage());
    }
}
