package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Result;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(String numbers) {
        Validator.lottoNumberValidate(numbers);
        this.numbers = stringToList(numbers);
    }

    private List<Integer> stringToList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)      // 앞 뒤 공백 제거
                .map(Integer::parseInt) // 정수로 변환
                .toList();
    }

    // 당첨 결과 계산 기능
    public void matcheNumber(List<List<Integer>> lotteryTickets, int bonusNumber) {
        for (List<Integer> lotteryTicket : lotteryTickets) {
            int matches = matchCount(lotteryTicket);

            if (matches == 5 && lotteryTicket.contains(bonusNumber)) {
                Result.SECOND.incrementCount();
                continue;
            }

            incrementCount(matches, bonusNumber, lotteryTicket);
        }
    }

    private int matchCount(List<Integer> lotteryTicket) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        copyNumbers.retainAll(lotteryTicket);
        return copyNumbers.size();
    }

    private void incrementCount(int matches, int bonusNumber, List<Integer> lotteryTicket) {
        for (Result result : Result.values()) {
            if (result.getMatches() == matches && !result.getBonus()) {
                result.incrementCount();
            }
        }
    }

}
