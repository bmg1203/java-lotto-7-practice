package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_COUNT_NOT_MATCHED;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_DUPLICATED;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateUnique(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    protected boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    protected boolean contains(int number) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.getNumber() == number);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_NOT_MATCHED.getMessage());
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (containsDuplicates(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    private boolean containsDuplicates(List<Integer> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size() != lottoNumbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }
}
