package lotto.collection;

import lotto.util.Validator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.checkLottoTickets(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
