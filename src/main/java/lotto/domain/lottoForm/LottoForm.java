package lotto.domain.lottoForm;

import lotto.domain.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constant.LottoValues.SIZE;
import static lotto.message.ErrorMessage.LOTTO_NUMBERS_DUPLICATE;
import static lotto.message.ErrorMessage.LOTTO_SIZE_ERROR;

public interface LottoForm {

    default List<LottoNumber> initializeNumbers(List<Integer> rawNumbers) {
        return validateAndSort(rawNumbers).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    default List<Integer> validateAndSort(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        return numbers.stream().sorted().toList();
    }

    private void validateSize(List<Integer> numbers) {
        if (!SIZE.isEqualTo(numbers.size())) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }
}
