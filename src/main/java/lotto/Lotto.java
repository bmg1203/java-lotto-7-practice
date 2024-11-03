package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final Integer LOTTO_NUMBERS_SIZE = 6;
    protected static final Integer lowerBound = 1;
    protected static final Integer upperBound = 45;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != getDistinctSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private static int getDistinctSize(List<Integer> numbers) {
        return numbers.stream().distinct().toList().size();
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(num ->
        {
            if (num < lowerBound || num > upperBound) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 숫자만 가능합니다.");
            }
        });
    }

    protected void containBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 로또 번호가 로또 번호와 중복되면 안 됩니다");
        }
    }

    // TODO: 추가 기능 구현

}
