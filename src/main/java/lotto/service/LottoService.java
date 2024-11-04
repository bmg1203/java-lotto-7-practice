package lotto.service;

import lotto.generator.LottoGenerator;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;

import java.util.List;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> generateLottos(int amount) {
        return lottoGenerator.generateLotto(amount);
    }

    public List<Rank> determineWinningRanks(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        return purchasedLottos.stream()
                .map(lotto -> determineRank(lotto, winningLotto))
                .toList();
    }

    private Rank determineRank(Lotto lotto, WinningLotto winningLotto) {
        return Rank.determineRank(lotto.getMatchingCount(winningLotto.winningNumbers()),
                lotto.hasBonusNumber(winningLotto.winningNumbers(), winningLotto.bonusNumber()));
    }
}