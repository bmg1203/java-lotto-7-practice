package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.message.LottoErrorMessage;
import lotto.domain.rule.LottoRules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static AutoLotto createRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoRules.MIN_NUMBER.getValue(),
                LottoRules.MAX_NUMBER.getValue(),
                LottoRules.NUMBER_COUNT.getValue()
        );
        return new AutoLotto(randomNumbers);
    }



    private void validate(List<Integer> numbers) {
        validateLottoNumCount(numbers);
        validateLottoNumbersInRange(numbers);
        checkNoDuplicateNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLottoNumCount(List<Integer> numbers) {
        if (!isLottoCountValid(numbers)) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateLottoNumbersInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (!isLottoNumberInRange(number)) {
                throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBER_IN_RANGE.getMessage());
            }
        });
    }

    private void checkNoDuplicateNumbers(List<Integer> numbers) {
        if (!hasNoDuplicates(numbers)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean isLottoCountValid(List<Integer> numbers) {
        return numbers.size() == LottoRules.NUMBER_COUNT.getValue();
    }


    private boolean isLottoNumberInRange(int lottoNumber) {
        return lottoNumber >= LottoRules.MIN_NUMBER.getValue() && lottoNumber <= LottoRules.MAX_NUMBER.getValue();
    }

    private boolean hasNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }
}