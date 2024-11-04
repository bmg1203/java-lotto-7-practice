package service;

import static java.util.stream.Stream.generate;
import static util.LottoResultCalculator.countMatchingResults;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.LottoList;
import lotto.LottoResult;
import lotto.PurchaseCount;
import lotto.WinningNumbers;

public class LottoService {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PRICE_UNIT = 1000;

    public PurchaseCount getCount(String purchaseAmountFromView) {
        int purchaseAmount = validatePurchaseAmount(purchaseAmountFromView);
        return new PurchaseCount(purchaseAmount);
    }

    public LottoList generateLottos(int purchaseCount) {
        List<Lotto> lottoList = generate(() -> new Lotto(generateRandomLottoNumbers()))
                .limit(purchaseCount)
                .collect(Collectors.toList());
        return new LottoList(lottoList);
    }

    public LottoResult getMatchingResult(WinningNumbers winningNumbers, LottoList lottoList) {
        List<Integer> matchResultList = lottoList.getMatchCounts(winningNumbers.getWinningNumbers(),
                winningNumbers.getBonusNumber());

        Map<Integer, Long> matchCounts = countMatchingResults(matchResultList);

        int threeMatchesCount = matchCounts.getOrDefault(3, 0L).intValue();
        int fourMatchesCount = matchCounts.getOrDefault(4, 0L).intValue();
        int fiveMatchesCount = matchCounts.getOrDefault(5, 0L).intValue();
        int sixMatchesCount = matchCounts.getOrDefault(6, 0L).intValue();
        int fiveMatchesWithBonusCount = matchCounts.getOrDefault(-1, 0L).intValue();

        return new LottoResult(threeMatchesCount, fourMatchesCount, fiveMatchesCount,
                fiveMatchesWithBonusCount, sixMatchesCount);
    }

    private int validatePurchaseAmount(String purchaseAmountFromView) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(purchaseAmountFromView);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해야 합니다.");
        }
        if (purchaseAmount < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000 이상이어야 합니다.");
        }
        if (purchaseAmount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }
}
