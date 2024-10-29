package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return getSortedNumbers();
    }

    private String getSortedNumbers() {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Collections.sort(copyNumbers);
        return copyNumbers.toString();
    }

    public void checkBonusNumberDuplication(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 될 수 없습니다");
        }
    }

    public int countContainNumber(Lotto winningNumbers) {
        return (int) winningNumbers.numbers.stream()
            .filter(winningNumber -> numbers.contains(winningNumber))
            .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.stream()
            .anyMatch(number -> number == bonusNumber);
    }
}
