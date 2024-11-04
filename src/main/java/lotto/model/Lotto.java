package lotto.model;

import static global.utils.Validator.validateLottoNumbers;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
