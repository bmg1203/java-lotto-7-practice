package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void outputNumberOfLotto(int numberOfLotto){
        System.out.println("\n"+numberOfLotto+"개를 구매했습니다.");
    }

    public void outputLottos(List<Lotto> lottoTickets){
        for (Lotto lottoTicket : lottoTickets) {
            List<Integer> numbers = lottoTicket.getNumbers();
            System.out.println(numbers);
        }
    }

    private void outputMatchCount(Map<LottoRank, Integer> rankCounts){
        for (Map.Entry<LottoRank, Integer> rankCount : rankCounts.entrySet()) {
            LottoRank lottoRank = rankCount.getKey();
            int count = rankCount.getValue();
            System.out.println(count+"개 일치");
            if(lottoRank == LottoRank.SECOND){
                System.out.println(", 보너스 볼 일치");
            }
            System.out.printf("("+String.format("%,d",lottoRank.getPrize())+") - "+count+"개");
        }
    }

    private void outputProfitRate(double profitRate){
        System.out.printf("총 수익률은 %.2f%%입니다.%n", profitRate);
    }

    public void outputStatistics(Map<LottoRank, Integer> rankCounts, double profitRate){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        outputMatchCount(rankCounts);
        System.out.println();
        outputProfitRate(profitRate);
    }
}
