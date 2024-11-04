package lotto.validation;

import java.util.HashSet;
import java.util.List;

import static lotto.common.constant.ErrorMessage.*;

public class LottoValidator {

    private static final Integer lottoNumberSize = 6;

    public static void validateLotto(List<Integer> numbers){
        throwExceptionIfListSizeIsInvalid(numbers);
        throwExceptionIfThereIsDuplicateNumber(numbers);
    }

    private static void throwExceptionIfListSizeIsInvalid(List<Integer> numbers) {
        if (numbers.size() != lottoNumberSize) {
            throw new IllegalArgumentException(LOTTO_SHOULD_BE_SIX.getErrorMessage());
        }
    }

    private static void throwExceptionIfThereIsDuplicateNumber(List<Integer> numbers) {
        if(numbers.size() != new HashSet<>(numbers).size()){
            throw new IllegalArgumentException(THERE_IS_DUPLICATE_NUMBER_IN_LOTTO.getErrorMessage());
        }
    }
}
