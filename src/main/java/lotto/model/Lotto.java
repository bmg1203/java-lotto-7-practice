package lotto.model;

import static lotto.common.AppConstant.LOTTO_NUMBER_COUNT;
import static lotto.common.error.AppErrorType.NUMBER_DUPLICATE_ERROR;
import static lotto.common.error.AppErrorType.NUMBER_SIZE_ERROR;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import lotto.common.error.AppException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream().sorted(Comparator.naturalOrder()).toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new AppException(NUMBER_SIZE_ERROR);
        }
    }
    
    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> deDuplicatedNumbers = new HashSet<>(numbers);

        if (deDuplicatedNumbers.size() != numbers.size()) {
            throw new AppException(NUMBER_DUPLICATE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public LottoRank getRankFrom(WinningLotto winningLotto) {
        List<Integer> winningNumberList = winningLotto.getWinningNumberList();
        int matchCount = this.numbers.stream().filter(winningNumberList::contains).toList().size();
        List<LottoRank> bonusRankList = LottoRank.rankListWithBonus();
        List<Integer> matchCountListOfBonusRank = bonusRankList.stream().map(rank -> rank.matchCount).toList();

        if (matchCountListOfBonusRank.contains(matchCount)) {
            int bonusNumber = winningLotto.getBonusNumber();

            return LottoRank.by(matchCount, numbers.contains(bonusNumber));
        }

        return LottoRank.by(matchCount, false);
    }
}
