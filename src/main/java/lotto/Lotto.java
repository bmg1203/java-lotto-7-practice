package lotto;

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

        for (int n : numbers) {
            if (!(n >= 1 && n <= 45)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 인 정수를 입력 해야 합니다.");
            }
        }

        List<Integer> distinctList = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 되는 로또 번호가 없어야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void matcheNumber(List<List<Integer>> lotteryTickets) {
        for (List<Integer> lts : lotteryTickets) {
            int count = matchCount(lts);
            resultCountUp(count);
        }
    }

    private int matchCount(List<Integer> lts) {
        int count = 0;
        for (Integer n : lts) {
            if (numbers.contains(n)) {
                count++;
            }
        }
        return count;
    }

    private void resultCountUp(int count) {
        for (Result result : Result.values()) {
            if (result.getMatches() == count && !result.getContainBonus()) {
                result.increamentCount();
            }
        }
    }
}
