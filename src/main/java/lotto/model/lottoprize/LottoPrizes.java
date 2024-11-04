package lotto.model.lottoprize;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.WinningNumbers;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;

public class LottoPrizes {
    private final List<LottoPrize> lottoPrizes;

    public LottoPrizes(Lottos lottos, WinningNumbers winningNumbers) {
        this.lottoPrizes = generatePrizes(lottos, winningNumbers);
    }

    public List<LottoPrize> getLottoPrizes() {
        return lottoPrizes;
    }

    private List<LottoPrize> generatePrizes(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.getLottos().stream()
                .map(lotto -> calculatePrize(lotto, winningNumbers))
                .collect(Collectors.toList());
    }

    private LottoPrize calculatePrize(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.countMatchingNumbers(lotto);
        boolean containsBonusNumber = winningNumbers.containsNumber(lotto);
        return LottoPrize.fromMatchCountAndBonus(matchCount, containsBonusNumber);
    }
}
