package lotto;

import java.util.List;
import java.util.ArrayList;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    public List<Integer> getNumbers() { return numbers; }
    public ArrayList<Integer> getNumbersArrayList() { return new ArrayList<Integer>(numbers); }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
