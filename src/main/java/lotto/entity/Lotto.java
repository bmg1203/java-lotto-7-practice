package lotto.entity;

import java.util.HashSet;
import java.util.List;
import lotto.exception.ErrorStatus;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        // 로또 갯수 체크
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_COUNT_OF_LOTTO_NUMBERS.getMessage());
        }

        // 중복 값 체크
        // 값 중복이 없는 hash를 이용해 개수를 비교
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorStatus.DUPLICATE_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
