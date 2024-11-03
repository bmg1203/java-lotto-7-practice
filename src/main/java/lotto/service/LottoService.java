package lotto.service;

import lotto.Lotto;
import lotto.util.ParseUtil;
import lotto.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoService {
    static final String DELIMITER = ",";
    private static Map<String, Integer> matchCountPrizeMap;
    private static final String[] matchNumbers = {"0", "1", "2", "3", "4", "5", "5.5", "6"};
    private static final int[] prizes = {0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000};

    public LottoService() {
        this.matchCountPrizeMap = IntStream.range(0, 8)
                .boxed()
                .collect(Collectors.toMap(i -> matchNumbers[i], i -> prizes[i]));
    }

    public List<Lotto> generateLottos(int size) {
        List<Lotto> lottos = IntStream.range(0, size)
                .mapToObj(i -> {
                    // 가변 리스트로 복사하여 생성
                    List<Integer> numbers = new ArrayList<>(RandomUtil.getSixRandomNumbers(1, 45));
                    Collections.sort(numbers); // 정렬
                    return new Lotto(numbers);
                })
                .collect(Collectors.toList());
        return lottos;
    }


    public Map<String, Integer> getMatchCounts(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<String, Integer> matchCounts = new HashMap<>();
        for (String matchNumber : matchNumbers) {
            matchCounts.put(matchNumber, 0);
        }

        lottos.stream()
                .map(lotto -> getMatchCount(lotto, winningLotto, bonusNumber))
                .forEach(matchCount -> matchCounts.put(matchCount, matchCounts.get(matchCount) + 1));

        return matchCounts;
    }

    private String getMatchCount(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = 0;
        for (int i : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(i)) matchCount++;
        }
        if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) return "5.5";
        return String.valueOf(matchCount);
    }

    public Lotto getWinningLotto(String winningNumbersInput) {
        List<String> tokens = ParseUtil.splitByDelimiters(winningNumbersInput, DELIMITER);
        List<Integer> winningNumbers = ParseUtil.parseToIntegerList(tokens);
        Lotto winningLotto = new Lotto(winningNumbers);
        return winningLotto;
    }

    public long getPrizeMoney(Map<String, Integer> matchCounts) {
        long totalPrizeMoney = 0;
        for (String matchNumber : matchNumbers) {
            int matchCount = matchCounts.get(matchNumber);
            totalPrizeMoney += (long) matchCount * matchCountPrizeMap.get(matchNumber);
        }
        return totalPrizeMoney;
    }

    public int getBonusNumber(String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        return bonusNumber;
    }

    public String getRateOfReturn(long totalPrizeMoney, int purchaseAmount) {
        double rateOfReturn = (double) totalPrizeMoney / purchaseAmount * 100;
        rateOfReturn = Math.round(rateOfReturn * 10.0) / 10.0;
        return String.format("%.1f", rateOfReturn);
    }
}
