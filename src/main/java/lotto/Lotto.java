package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

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
    }

    public static List<Integer> pickRandomNumber() {
            return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    @Override
    public String toString() {
        return numbers.toString(); // 리스트 형식으로 출력
    }
}
