package lotto.service;

import static java.util.stream.Collectors.toList;
import static lotto.CommonSymbols.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;

public class LottoService {
    public List<Lotto> generateLottos(String purchaseAmount) {
        int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);

        int lottoCount = parsedPurchaseAmount / 1000;

        return IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }

    public String getFormattedLottoNumbers(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::formattedNumbers)
                .collect(Collectors.joining(NEW_LINE.getSymbol()));
    }

    public Map<Integer, Integer> winningDetermination(String winningNumbers, String bonusNumber,
                                                      List<Lotto> lottos) {
        List<Integer> parsedWinningNumbers = parseWinningNumbers(winningNumbers);
        int parsedBonusNumber = parseBonusNumber(bonusNumber);

        Map<Integer, Integer> matchCounts = initializeMatchCounts();

        lottos.forEach(lotto -> {
            int matchCount = lotto.countMatchingNumbers(parsedWinningNumbers);
            boolean isBonusMatch = lotto.containsBonusNumber(parsedBonusNumber);

            updateMatchCounts(matchCounts, matchCount, isBonusMatch);
        });

        return matchCounts;
    }

    private List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber.trim());
    }

    private Map<Integer, Integer> initializeMatchCounts() {
        Map<Integer, Integer> matchCounts = new HashMap<>();
        for (int count = 3; count <= 6; count++) {
            matchCounts.put(count, 0);
        }
        matchCounts.put(-5, 0); // 5개 + 보너스
        return matchCounts;
    }

    private void updateMatchCounts(Map<Integer, Integer> matchCounts, int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            matchCounts.put(-5, matchCounts.get(-5) + 1);
            return;
        }

        if (matchCount == 5) {
            matchCounts.put(5, matchCounts.get(5) + 1);
            return;
        }

        if (matchCount >= 3) {
            matchCounts.put(matchCount, matchCounts.get(matchCount) + 1);
        }
    }

    public double calculateYield(Map<Integer, Integer> matchCounts, int purchaseAmount) {
        int totalPrize = (matchCounts.get(3) * 5000) + (matchCounts.get(4) * 50000)
                + (matchCounts.get(5) * 1500000) + (matchCounts.get(-5) * 30000000)
                + (matchCounts.get(6) * 2000000000);

        double rawYield = (double) totalPrize / purchaseAmount * 100;
        BigDecimal roundedYield = BigDecimal.valueOf(rawYield).setScale(2, RoundingMode.HALF_UP);

        return roundedYield.doubleValue();
    }
}
