package view;

import lotto.Lotto;
import lotto.Prize;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OutputHandler {

    public void promptForAmountInput(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void promptForLottoNumber(){
        System.out.println("\n" +"당첨 번호를 입력해 주세요.");
    }
    public void promptForBonusNumber(){
        System.out.println("\n" +"보너스 번호를 입력해 주세요.");
    }
    public void displayPurchasedLottoCount(int count){
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void displayPrizes(EnumMap<Prize, Integer> prizeCount) {
        System.out.println("\n" + "당첨 통계" + "\n" + "---");
        for (Prize prize : Prize.values()) {
            System.out.println(prize.getRanking() + "개 일치 " + "(" + prize.getPrizeMoney() + "원) - " + prizeCount.get(prize) + "개");
        }
    }

    public void displayWinningRate(double winningRate) {
        String formattedValue = String.format("%.1f", winningRate);
        System.out.println("총 수익률은 " + formattedValue + "%입니다.");
    }

    public void showLottos(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers.toString());
    }
}
