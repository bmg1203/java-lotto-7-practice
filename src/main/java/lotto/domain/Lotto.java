package lotto.domain;

import static lotto.service.exception.LottoExceptionMessage.INVALID_WINNING_NUMBERS;

import java.util.List;
import lotto.service.exception.LottoException;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto.getLotto().getNumbers()::contains)
                .count();
    }

    public boolean containsBonusNumber(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .reduce((num1, num2) -> num1 + ", " + num2)
                .map(result -> "[" + result + "]")
                .orElse("[]");
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(INVALID_WINNING_NUMBERS);
        }
    }

}