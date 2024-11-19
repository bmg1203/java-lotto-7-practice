package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumbers.LOTTO_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT_ERROR.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> lottoSet = new HashSet<>(numbers);

        if (lottoSet.size() != LottoNumbers.LOTTO_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoNumbers.LOTTO_MIN_RANGE.getNumber() ||
                number > LottoNumbers.LOTTO_MAX_RANGE.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE_ERROR.getMessage());
            }
        }
    }
}
