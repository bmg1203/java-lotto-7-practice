package lotto.validator;

import static lotto.util.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.util.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.util.LottoConstants.REQUIRED_LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
