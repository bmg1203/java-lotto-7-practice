package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final static int LOTTO_NUMBER_UPPER_BOUND = 45;
    private final static int LOTTO_NUMBER_LOWER_BOUND = 1;
    private final static int NUMBER_OF_LOTTO_NUMBERS = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberOfLottoNumbers(numbers);
        validateLottoNumberRange(numbers);
        validateLottoDuplicated(numbers);
    }

    private void validateNumberOfLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 1~45 범위를 벗어납니다.");
            }
        }
    }

    private void validateLottoDuplicated(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() < NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        return "[" + String.join(", ", sortedNumbers.stream().map(num -> num.toString()).toList()) + "]";
    }
}
