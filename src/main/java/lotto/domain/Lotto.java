package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Integer matchCount = 0;
    private Boolean bonusExist = false;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public void match(List<String> winningNums, String bonusNum) {
        for (String winningNum : winningNums) {
            if (numbers.contains(Integer.parseInt(winningNum))) {
                this.matchCount++;
            }
        }
        if (numbers.contains(Integer.parseInt(bonusNum))) {
            bonusExist = true;
        }
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Boolean getBonusExist() {
        return bonusExist;
    }

    @Override
    public String toString() {
        List<Integer> collected = numbers.stream().sorted().toList();
        return collected.toString();
    }
}
