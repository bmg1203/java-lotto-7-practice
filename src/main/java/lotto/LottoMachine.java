package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    public List<Lotto> createLotto(int quantity){
        System.out.printf("\n%d개를 구매했습니다.\n", quantity);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Lotto lotto = new Lotto(sortedNumbers);
            System.out.println(lotto);
            lottos.add(lotto);
        }

        return lottos;
    }

    public List<String> getWinningStatistics(Map<LottoRank, Integer> rankCounts){
        List<String> winningStatistics = new ArrayList<>();
        for (LottoRank rank : sortLottoRanks(rankCounts.keySet())){
            StringBuilder statistic = new StringBuilder();
            statistic.append(String.format("%d개 일치", rank.getMatchCount()));
            if (rank == LottoRank.SECOND) statistic.append(", 보너스 볼 일치");
            statistic.append(String.format(" (%,d원) - %d개",rank.getWinnings(), rankCounts.get(rank)));
            winningStatistics.add(statistic.toString());
        }
        return winningStatistics;
    }

    public Map<LottoRank, Integer> getRankCounts(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber){
        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) rankCounts.put(lottoRank, 0);

        for (Lotto lotto : lottos){
            int matchCount = lotto.countMatchingWinningNumbers(winningNumbers);
            boolean isMatchBonus = lotto.isMatchBonusNumber(bonusNumber);
            LottoRank currentRank = LottoRank.getRank(matchCount, isMatchBonus);
            rankCounts.computeIfPresent(currentRank, (key, value) -> value + 1);
        }
        return rankCounts;
    }

    public double calculateReturnRate(Map<LottoRank, Integer> rankCounts, int price){
        double totalWinnings = 0;
        for (LottoRank rank : rankCounts.keySet())
            totalWinnings += rank.getWinnings() * rankCounts.get(rank);
        return (totalWinnings / price) * 100;
    }

    private List<LottoRank> sortLottoRanks(Set<LottoRank> lottoRanks){
        List<LottoRank> lottoRanksList = new ArrayList<>(List.copyOf(lottoRanks));
        lottoRanksList.sort(Comparator.comparingInt(LottoRank::getWinnings));
        return lottoRanksList;
    }
}
