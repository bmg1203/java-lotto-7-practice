package lotto.model;

import java.util.List;
import lotto.validator.Validator;

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
        Validator.validateLottoDuplicate(numbers);
        Validator.validateNumberCount(numbers);
    }

    // TODO: 추가 기능 구현
    public Result compareWithWinningLotto(List<Integer> winningLotto, int bonusNumber){
        boolean isBonusMatch = false;
        int duplicateNumber = 0;
        for(Integer number : winningLotto){
            if(numbers.contains(number)){
                duplicateNumber ++;
            }
        }
        if(duplicateNumber == 5 && numbers.contains(bonusNumber)){
            isBonusMatch = true;
        }
        return Result.findResult(duplicateNumber,isBonusMatch);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
