package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        List<Integer> duplicatedNumbers = numbers.stream()
                .filter(o -> Collections.frequency(numbers, o) > 1)
                .toList();

        if (!duplicatedNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현

    // LottoWinningNumbers와 비교하는 메서드 (일치하는 숫자의 개수를 리턴)
    public long compareResult(LottoWinningNumbers winningNumbers) {
        return numbers.stream()
                .filter(o -> winningNumbers.getWinningNumbers().stream()
                        .anyMatch(Predicate.isEqual(o)))
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // toString 메서드 재정의
    public String toString() {
        String collected = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return "[ " + collected + " ]";
    }
}
