package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.WinningType;

public class CheckWinning {

    public static void checkDuplicateNum(Lotto winningNumber, List<Lotto> lottoList, int bonusNum){
        int matchNum = 0;


        for (Lotto lotto : lottoList) {
            matchNum = lotto.findDuplicateNum(winningNumber.getNumbers());

            if(matchNum == 3){
                WinningType.FIRST.countUp();
            }
            if(matchNum == 4){
                WinningType.SECOND.countUp();
            }
            if(matchNum == 5){
                if(lotto.checkDuplicateWithBonusNumber(bonusNum)){
                    WinningType.FOURTH_BONUS.countUp();
                    continue;
                }
                WinningType.THIRD.countUp();
            }
            if(matchNum == 6){
                WinningType.FIFTH.countUp();
            }
        }
    }

    public static double calculateProfit(int inputPrice){

        long allProfit = 0;
        allProfit += ((long) WinningType.FIRST.getCount() * WinningType.FIRST.getPrizeMoney());
        allProfit += ((long) WinningType.SECOND.getCount() * WinningType.SECOND.getPrizeMoney());
        allProfit += ((long) WinningType.THIRD.getCount() * WinningType.THIRD.getPrizeMoney());
        allProfit += ((long) WinningType.FOURTH_BONUS.getCount() * WinningType.FOURTH_BONUS.getPrizeMoney());
        allProfit += ((long) WinningType.FIFTH.getCount() * WinningType.FIFTH.getPrizeMoney());


        double profit = (double)(allProfit/inputPrice)*100;
        profit = Math.round(profit);

        return profit;
    }

}
