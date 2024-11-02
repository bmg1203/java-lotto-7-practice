package lotto.model;

import java.util.HashSet;
import java.util.List;
import lotto.constant.LottoConfiguration;

public class Lotto {

    public static final String NUMBER_DUPLICATION_EXCEPTION_MESSAGE = "로또 번호는 중복이 존재하면 안됩니다.";
    public static final String INCORRECT_NUMBER_COUNT_EXCEPTION_MESSAGE =
            String.format("로또 번호는 %d 개여야 합니다.", LottoConfiguration.LOTTO_NUMBER_COUNT);
    public static final String OUT_OF_RANGE_NUMBER_EXCEPTION_MESSAGE =
            String.format("로또번호는 %d~%d 사이여야 합니다.",
                    LottoConfiguration.LOTTO_NUMBER_RANGE_START, LottoConfiguration.LOTTO_NUMBER_RANGE_END);

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberDuplication(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConfiguration.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        HashSet<Integer> notDuplicatedNumber = new HashSet<>(numbers);
        if (notDuplicatedNumber.size() != LottoConfiguration.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(int number) {
        if (number < LottoConfiguration.LOTTO_NUMBER_RANGE_START
                || number > LottoConfiguration.LOTTO_NUMBER_RANGE_END) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
