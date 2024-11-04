package lotto;

import constant.ErrorConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {


    private static final int LOTTO_NUMBER_COUNT_SIX = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {

        this.numbers = new ArrayList<>(numbers);
        validate(numbers);
        sortNumbers();
    }


    private void sortNumbers() {
        Collections.sort(numbers);
    }


    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }


    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT_SIX) {
            throw new IllegalArgumentException(ErrorConst.ERROR_INVALID_NUMBER_COUNT);
        }

    }


    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > MAX_LOTTO_NUMBER || numbers.get(i) < MIN_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorConst.ERROR_NUMBER_OUT_OF_RANGE);
            }
        }
    }


    private void validateDuplicate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                throw new IllegalArgumentException(ErrorConst.ERROR_DUPLICATE_NUMBER);
            }
        }

    }


    public List<Integer> getLottoNumbers() {
        return new ArrayList<>(numbers);
    }


}
