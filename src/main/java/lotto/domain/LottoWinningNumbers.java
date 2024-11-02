package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumbers {
    private final List<Integer> lottoWinningNumbers;
    public int bonusNumber;

    public LottoWinningNumbers(List<Integer> lottoWinningNumbers, int bonusNumber) {
        validate(lottoWinningNumbers, bonusNumber);
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    private void validate(List<Integer> numbers, int bonus){
        validateNum(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        validateDuplicateBonus(numbers, bonus);
    }
    private void validateNum(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers){
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45 사이여야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private void validateDuplicateBonus(List<Integer> numbers, int bonus){
        Set<Integer> dupnumbers = new HashSet<>(numbers);
        dupnumbers.add(bonus);

        if(dupnumbers.size() == numbers.size())
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.");
    }
}
