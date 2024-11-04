package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberException;
import lotto.util.enums.ExceptionMessages;
import lotto.util.enums.Rank;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoNumberException(ExceptionMessages.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (hasDuplicateNumbers(numbers)) {
            throw new LottoNumberException(ExceptionMessages.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public Rank calculateRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = countMatchingNumbers(winningNumbers);
        boolean bonusMatch = isBonusMatched(bonusNumber);

        return determineRank(matchCount, bonusMatch);
    }

    private int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusMatched(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private Rank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return Rank.FIRST;
        }

        if (matchCount == 5) {
            return bonusMatch ? Rank.SECOND : Rank.THIRD;
        }

        if (matchCount == 4) {
            return Rank.FOURTH;
        }

        if (matchCount == 3) {
            return Rank.FIFTH;
        }

        return Rank.NONE;
    }

}
