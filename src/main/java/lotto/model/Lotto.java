package lotto.model;

import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isDuplicated(numbers);
        hasLengthSix(numbers);
        isOutofRange(numbers);
    }

    private static void isDuplicated(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()){
            throw new InputException(ExceptionMessage.DUPLICATED_NUMBER_ERROR);
        }
    }

    private static void hasLengthSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InputException(ExceptionMessage.INVALID_COUNT_ERROR);
        }
    }

    private static void isOutofRange(List<Integer> numbers){
        for (Integer number : numbers) {
            if(number < 1 || number > 45){
                throw new InputException(ExceptionMessage.NUMBER_RANGE_ERROR);
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

}
