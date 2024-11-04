package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Validator.DELIMITER;
import static lotto.model.LottoRank.getLottoRank;

public class LottoManager {
    public Lotto generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public Lotto parseWinningNumbersToLotto(String winningNumbers) {
        List<Integer> numberList = Arrays.stream(winningNumbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numberList);
    }

    public Map<LottoRank, Long> analyzeLottoResults(List<Lotto> lottoSets, Lotto winningNumbers, int bonusNumber) {
        List<LottoRank> lottoRankResults = new ArrayList<>();
        for (Lotto currentLottoNumbers : lottoSets) {
            boolean hasBonusNumber = false;
            int hitCount = countHitCount(currentLottoNumbers.getLotto(), winningNumbers.getLotto());
            hasBonusNumber = checkHasBonusNumber(hitCount,currentLottoNumbers.getLotto(),bonusNumber);
            lottoRankResults.add(getLottoRank(hitCount, hasBonusNumber));
        }
        return lottoRankResults.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private boolean checkHasBonusNumber(int hitCount, List<Integer> lotto, int bonusNumber) {
        return hitCount == 5 && lotto.contains(bonusNumber);
    }


    private int countHitCount(List<Integer> currentLottoNumbers, List<Integer> winningNumbers) {
        int hitCount = 0;
        for (int number : currentLottoNumbers) {
            if (winningNumbers.contains(number)) {
                hitCount++;
            }
        }
        return hitCount;
    }

    public String getReturnRate(Map<LottoRank, Long> lottoRankResults, int paymentAmount) {
        double totalIncome = 0.0;
        for (Map.Entry<LottoRank, Long> entry : lottoRankResults.entrySet()) {
            LottoRank rank = entry.getKey();
            Long count = entry.getValue();
            totalIncome += rank.getPrizeMoney() * count;
        }
        double returnRate = (totalIncome / paymentAmount) * 100;
        return String.format("%.1f%%", returnRate);
    }

}
