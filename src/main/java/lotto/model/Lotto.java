package lotto.model;

import java.util.List;
import lotto.message.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.UNAVAILABLE_LOTTO_NUMBERS_LENGTH.getMessage());
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
