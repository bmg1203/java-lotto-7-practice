package lotto.service.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.LottoConstants;
import lotto.domain.bonus.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.WinningContext;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningResult;
import lotto.exception.lotto.LottoErrorMessages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoServiceImpl implements LottoService {
    @Override
    public boolean validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NON_POSITIVE.getMessage());
        }
        if (amount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
        }
        return true;
    }

    @Override
    public WinningResult checkResult(Lotto lotto, WinningContext context) {
        WinningNumbers winningNumbers = context.getWinningNumbers();
        BonusNumber bonusNumber = context.getBonusNumber();

        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNums = winningNumbers.getNumbers();
        int matchCount = (int) lottoNumbers.stream().filter(winningNums::contains).count();
        boolean hasBonus = lottoNumbers.contains(bonusNumber.getNumber());

        return determineRank(matchCount, hasBonus);
    }

    @Override
    public double calculateEarningsRate(int totalPrize, int amount) {
        double rate = ((double) totalPrize / amount) * 100;
        return Math.round(rate * 100) / 100.0;
    }

    @Override
    public List<Lotto> generateLottos(int amount) {
        int count = amount / LottoConstants.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateRandomLotto());
        }

        return lottos;
    }

    private Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, LottoConstants.LOTTO_NUMBER_COUNT);
        return new Lotto(randomNumbers);
    }

    private WinningResult determineRank(int matchCount, boolean hasBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount && (!rank.hasBonus() || hasBonus)) {
                return new WinningResult(rank);
            }
        }
        return new WinningResult(Rank.NO_WIN);
    }
}

