package lotto.domain;

import static lotto.global.error.LottoErrorMessages.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.LottoRank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
        }
    }

    public LottoRank checkWinningStatus(List<Integer> winningNumbers, int bonusNumber) {

        int matchCount = (int) winningNumbers.stream().filter(numbers::contains).count();

        if (matchCount < 3) {
            return null;
        }

        if (matchCount != 5) {
            return LottoRank.findByMatchCount(matchCount);
        }

        if (numbers.contains(bonusNumber)) {
            return LottoRank.SECOND;
        }

        return LottoRank.THIRD;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
