package lotto.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.Randoms;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    // 기존 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 무작위 로또 번호 생성
    public static Lotto generateRandomLotto() {
        Set<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
        List<Integer> numbersList = uniqueNumbers.stream().collect(Collectors.toList());
        return new Lotto(numbersList);
    }

    // 유효성 검사
    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
            }
        }
    }

    // 로또 번호 확인 메소드
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    // Getter for numbers (optional)
    public List<Integer> getNumbers() {
        return numbers;
    }
}
