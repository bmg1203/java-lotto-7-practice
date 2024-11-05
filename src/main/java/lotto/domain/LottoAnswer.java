package lotto.domain;

import java.util.List;
import lotto.constant.LottoConstant;

public class LottoAnswer {
    private final List<Integer> numbers;

    public LottoAnswer(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.ANSWER_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    "[ERROR] 당첨 번호는 " + LottoConstant.ANSWER_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LottoConstant.LOTTO_NUMBER_MIN_RANGE
                || number > LottoConstant.LOTTO_NUMBER_MAX_RANGE)) {
            throw new IllegalArgumentException("[ERROR] 유효한 범위의 숫자가 아닙니다.");
        }
    }

    public boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }

}
