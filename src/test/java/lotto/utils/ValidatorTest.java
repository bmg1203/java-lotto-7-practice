package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 숫자를_입력하지_않으면_예외가_발생한다() {
        String amount = "1000원";

        assertThatThrownBy(() -> Validator.isNumber(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_NUMBER_MESSAGE);
    }

    @Test
    void 단위_1000으로_입력하지_않으면_예외가_발생한다() {
        int amount = 1500;

        assertThatThrownBy(() -> Validator.amountIsMultipleOf1000(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_AMOUNT_MESSAGE);
    }

    @Test
    void 범위에_맞지_않는_숫자를_입력하면_예외가_발생한다() {
        int number = 46;

        assertThatThrownBy(() -> Validator.numberInRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_NUMBER_RANGE_MESSAGE);
    }

    @Test
    void 범위에_맞지_않는_음수를_입력하면_예외가_발생한다() {
        int number = -1;

        assertThatThrownBy(() -> Validator.numberInRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_NUMBER_RANGE_MESSAGE);
    }

    @Test
    void 당첨_번호_6개를_입력하지_않으면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3);

        assertThatThrownBy(() -> Validator.numbersLength(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_NUMBER_LENGTH_MESSAGE);
    }

    @Test
    void 중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> Validator.numberDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_NUMBERS_DUPLICATE_MESSAGE);
    }

    @Test
    void 당첨_번호와_중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> Validator.numberIsUnique(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_NUMBERS_CONTAIN_DUPLICATE);
    }
}
