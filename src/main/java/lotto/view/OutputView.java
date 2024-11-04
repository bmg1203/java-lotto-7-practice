package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String GET_MONEY_TO_BUY_LOTTO = "구입금액을 입력해 주세요.";
    private static final String SHOW_PUBLICED_LOTTO_NUM = "%d개를 구매했습니다.\n";
    private static final String GET_LOTTO_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String GET_LOTTO_BONUS_NUM = "보너스 번호를 입력해 주세요.";
    private static final String SHOW_LOTTO_RESULT_START = "당첨 통계\n---";
    private static final String SHOW_LOTTO_RESULT = "%d개 일치 (%s원) - %d개\n";
    private static final String SHOW_LOTTO_RESULT_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String SHOW_LOTTO_PROFIT_RATE = "총 수익률은 %s%%입니다.";

    public void showHowMuchMoneyToBuyLotto() {
        System.out.println(GET_MONEY_TO_BUY_LOTTO);
    }

    public void showPublicedLottos(List<Lotto> lottos){
        System.out.printf(SHOW_PUBLICED_LOTTO_NUM, lottos.size());
        for(Lotto lotto : lottos){
            List<Integer> sortedNumbers = lotto.getNumbers();
            Collections.sort(sortedNumbers); // 번호를 오름차순으로 정렬
            System.out.println(sortedNumbers);
        }
    }

    public void enterWinningNumberForLotto(){
        System.out.println(GET_LOTTO_WINNING_NUM);
    }

    public void enterBonusNumberForLotto(){
        System.out.println(GET_LOTTO_BONUS_NUM);
    }
    
    public void showLottoResults(Map<LottoRank, Integer> lottoResult){
        System.out.println(SHOW_LOTTO_RESULT_START);
        for(LottoRank rank : LottoRank.values()){
            int count = lottoResult.getOrDefault(rank, 0);
            String reward = String.format("%,d", rank.getReward());
            if(rank == LottoRank.SECOND){
                System.out.printf(SHOW_LOTTO_RESULT_BONUS, rank.getMatchNumber(), reward, count);
                continue;
            }

            if(rank!=LottoRank.NOTHING){
                System.out.printf(SHOW_LOTTO_RESULT, rank.getMatchNumber(), reward, count);
                continue;
            }
        }
    }

    public void showProfitRate(double profitRate){
        System.out.printf(SHOW_LOTTO_PROFIT_RATE, String.format("%.1f", profitRate));
    }
}
