package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberException;
import lotto.exception.LottoSizeException;
import lotto.exception.message.Error;

public class Lotto {

    private static final int FIX_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != FIX_SIZE) {
            throw new LottoSizeException(FIX_SIZE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> removalDuplication = new HashSet<>(numbers);

        if (numbers.size() != removalDuplication.size()) {
            throw new LottoNumberException(Error.DUPLICATED_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
