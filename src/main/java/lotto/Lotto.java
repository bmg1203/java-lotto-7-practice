package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final static int NUMBERS_LENGTH = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
        }
    }

    public int countMatchesWith(Lotto other) {
        return Math.toIntExact(numbers.stream()
                .filter(other::contains)
                .count());
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }
}
