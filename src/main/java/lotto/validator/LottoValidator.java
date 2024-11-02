package lotto.validator;

import lotto.utils.ExceptionUtils;

import java.util.HashSet;
import java.util.List;

import static lotto.constants.ErrorMessage.ERROR_LOTTO_COUNT;
import static lotto.constants.ErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATE;
import static lotto.constants.LottoValue.LOTTO_NUMBER_COUNT;

public class LottoValidator {

    public static void validateLotto(final List<Integer> numbers){
        checkNumberCount(numbers);
        checkNumberDuplicate(numbers);
    }

    private static void checkNumberCount(final List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBER_COUNT.getValue()){
            ExceptionUtils.throwIllegalArgument(ERROR_LOTTO_COUNT.getMessage());
        }
    }

    private static void checkNumberDuplicate(final List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            ExceptionUtils.throwIllegalArgument(ERROR_LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }
}
