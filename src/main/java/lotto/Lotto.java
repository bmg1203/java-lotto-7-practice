package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Lotto {
    private final List<Integer> winningNumbers;

    public Lotto(List<Integer> numbers) {
        this.winningNumbers = numbers;
    }

    // 각 로또 번호 확인
    public void calculateStatistics(List<List<Integer>> buyLottoNumbers, int bonusNumber, int buyLottoAmount) {
        Map<WinningNums, Integer> statistics = new HashMap<>();

        // 모든 WinningNums 초기화
        for (WinningNums rank : WinningNums.values()) {
            statistics.put(rank, 0);
        }

        // 각 로또 번호와 당첨 번호를 비교하여 통계 업데이트
        for (List<Integer> lottoNumbers : buyLottoNumbers) {
            int matchingCount = 0;

            for (int number : lottoNumbers) {
                if (winningNumbers.contains(number)) {
                    ++matchingCount;
                }
            }
            WinningNums rank = WinningNums.checkRank(matchingCount);
            if(matchingCount == 5 && lottoNumbers.contains(bonusNumber)){
                rank = WinningNums.FIVE_BONUS;
            }

            statistics.put(rank, statistics.get(rank) + 1); // 해당 등수의 개수 증가
        }

        printStatistics(statistics);
        printRate(statistics, buyLottoAmount);
    }

    // 통계 결과를 출력하는 메서드
    private void printStatistics(Map<WinningNums, Integer> statistics) {
        System.out.println("\n당첨 통계\n---");

        // WinningNums 값을 역순으로 반복
        WinningNums[] ranks = WinningNums.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            WinningNums rank = ranks[i];
            if (rank != WinningNums.NONE) {
                System.out.printf("%s (%,d원) - %d개\n",
                        rank.getName(), rank.getPrize(), statistics.get(rank));
            }
        }
    }

    private void printRate(Map<WinningNums, Integer> statistics, int buyLottoAmount){
        double profit = 0;
        for (WinningNums rank : WinningNums.values()) {
            if (rank != WinningNums.NONE) {
                profit += rank.getPrize() * statistics.get(rank);
            }
        }
        double rate = profit/(buyLottoAmount*1000) * 100;
        rate = Math.round(rate * 100) / 100.0;
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }


}
