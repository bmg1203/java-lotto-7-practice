package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 일치하는 번호의 개수를 세는 메서드
    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    // 보너스 번호가 포함되어 있는지 확인하는 메서드
    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    // TODO: 추가 기능 구현
}
