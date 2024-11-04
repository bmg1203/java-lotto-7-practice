package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {

    @Test
    void 당첨번호가_6개가_아닌_경우_예외(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(LottoException.class, () -> LottoValidator.validateWinningNumbers(numbers));
    }

    @Test
    void 당첨번호에_중복이_있으면_예외(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,5);
        assertThrows(LottoException.class, () -> LottoValidator.validateWinningNumbers(numbers));
    }

    @Test
    void 당첨번호가_범위를_벗어나면_예외(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThrows(LottoException.class, () -> LottoValidator.validateWinningNumbers(numbers));
    }

    @Test
    void 보너스_번호가_범위를_벗어나면_예외(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;
        assertThrows(LottoException.class, () -> LottoValidator.validateBonusNumber(bonusNumber, winningNumbers));
    }

    @Test
    void 보너스_번호가_당첨번호와_중복이_있으면_예외(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;
        assertThrows(LottoException.class, () -> LottoValidator.validateBonusNumber(bonusNumber, winningNumbers));
    }
}
