package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_RANGE_MAX;
import static lotto.constants.LottoConstants.LOTTO_RANGE_MIN;
import static lotto.constants.LottoConstants.LOTTO_SIZE;
import static lotto.error.ErrorType.DUPLICATION_BONUS_NUM;
import static lotto.error.ErrorType.DUPLICATION_WINNING_NUM;
import static lotto.error.ErrorType.INSUFFICIENT_OR_EXCESSIVE_NUMBERS;
import static lotto.error.ErrorType.INVALID_NUMBER_FORMAT;
import static lotto.error.ErrorType.OUT_OF_RANGE_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.exception.InvalidBonusNumberException;
import lotto.error.exception.InvalidLottoNumberException;
import lotto.error.exception.InvalidNumberFormatException;
import lotto.generator.LottoGenerator;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomNumberLotto(final LottoGenerator lottoGenerator) {
        final List<Integer> generatedSortedNumbers = lottoGenerator.generate().stream()
                .sorted().toList();
        return new Lotto(generatedSortedNumbers);
    }

    public static Lotto createFixedNumberLotto(final List<Integer> numbers) {
        final List<Integer> sortedNumber = numbers.stream().sorted().toList();
        return new Lotto(sortedNumber);
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicate(numbers);
        numbers.forEach(this::validateNumberRange);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateBonusNumber(final String bonusNumberInput) {
        final int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(INVALID_NUMBER_FORMAT);
        }

        if (numbers.contains(bonusNumber)) {
            throw new InvalidBonusNumberException(DUPLICATION_BONUS_NUM);
        }
        validateNumberRange(bonusNumber);
    }

    public int calculateMatchCount(final Lotto winningLotto) {
        final List<Integer> winningNumbers = winningLotto.getNumbers();
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isBonusMatched(final int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoNumberException(INSUFFICIENT_OR_EXCESSIVE_NUMBERS);
        }
    }

    private void validateNoDuplicate(final List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new InvalidLottoNumberException(DUPLICATION_WINNING_NUM);
        }
    }

    private void validateNumberRange(final int number) {
        if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
            throw new InvalidLottoNumberException(OUT_OF_RANGE_NUMBER);
        }
    }
}
