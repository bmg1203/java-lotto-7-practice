package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (isDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public static boolean isDuplicate(List<Integer> numbers){
        Set<Integer> hashSet = new HashSet<>(numbers);
        return hashSet.size() != numbers.size();
    }

    public Rank rank(WinningNumber winningNumber){
        int cnt = 0;
        for (Integer number : numbers) {
            if(winningNumber.contains(number))cnt++;
        }
        boolean bonusMatch = numbers.contains(winningNumber.getBonusNumber());
        return Rank.valueOf(cnt, bonusMatch);
    }
}
