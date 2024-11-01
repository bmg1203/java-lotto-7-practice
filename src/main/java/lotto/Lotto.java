package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<>();
        for (Integer number : numbers) {
            if(!unique.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
            }
        }

    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public static void main(String[] args) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6, 70));
    }

}
