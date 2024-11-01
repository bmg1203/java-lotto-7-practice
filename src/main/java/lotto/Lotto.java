package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isCountEqualsToSix(numbers);
        this.numbers = numbers;
    }

    private void isCountEqualsToSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }


}
