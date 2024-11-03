package lotto.domain;

import static lotto.constants.ErrorMessage.DUPLICATED_IN_LOTTO_NUMBERS;
import static lotto.constants.ErrorMessage.INPUT_LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.constants.ErrorMessage.LOTTO_SIZE_MUST_BE_SIX;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumbersSize(numbers);
        checkNumberRange(numbers);
        checkNumberDuplicated(numbers);
    }

    // TODO: 추가 기능 구현
    private void checkNumbersSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_MUST_BE_SIX.getMessage());
        }
    }

    private void checkNumberRange(List<Integer> numbers){
        for(Integer number : numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException(INPUT_LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void checkNumberDuplicated(List<Integer> numbers){
        Set<Integer> filterNumbers = new HashSet<>(numbers);
        if (filterNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_IN_LOTTO_NUMBERS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
