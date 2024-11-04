package lotto.validator;

import java.util.HashSet;
import java.util.Set;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

import java.util.List;

public class LottoValidator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public void bonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw LottoException.from(ErrorMessage.BONUS_NUMBER_DUPLICATES_WITH_WINNING_NUMBERS);
        }
    }

    public void numberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw LottoException.from(ErrorMessage.LOTTO_NUMBERS_MUST_BE_SIX);
        }
    }

    public void numberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw LottoException.of(ErrorMessage.LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45, number);
        }
    }

    public void duplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw LottoException.of(ErrorMessage.LOTTO_NUMBERS_MUST_NOT_DUPLICATE, number);
        }
    }

    public void duplicate(List<Integer> winningNumbers) {
        Set<Integer> seen = new HashSet<>();

        for (Integer number : winningNumbers) {
            if (!seen.add(number)) {
                throw LottoException.of(ErrorMessage.LOTTO_NUMBERS_MUST_NOT_DUPLICATE, number);
            }
        }
    }
}
