package lotto.controller;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class OutputController {
    public static List<List<Integer>> getLottoNumbers(int purchaseQuantity){
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoNumbersList.add(lottoNumbers);
        }
        return lottoNumbersList;
    }

    public static int[] calculateStatistics(List<Integer> winningNumbers, List<List<Integer>> lottoNumbersList) {
        int[] matchCounts = new int[7];
        for (List<Integer> ticket : lottoNumbersList) {
            int matches = countMatches(ticket, winningNumbers);
            if (matches > 0) {
                matchCounts[matches - 1]++;
            }
        }
        return matchCounts;
    }

    private static int countMatches(List<Integer> ticket, List<Integer> winningNumbers) {
        return (int) ticket.stream().filter(winningNumbers::contains).count();
    }

    public static double calculateProfit(int totalSpent, int totalPrize) {
        if (totalSpent == 0) {
            return 0;
        }
        return (double) totalPrize / totalSpent * 100;
    }
    public static int calculateTotalPrize(int[] matchPoints) {
        int totalPrize = 0;
        totalPrize += matchPoints[2] * 5000;
        totalPrize += matchPoints[3] * 50000;
        totalPrize += matchPoints[4] * 1500000;
        totalPrize += matchPoints[5] * 30000000;
        totalPrize += matchPoints[6-1] * 2000000000;
        return totalPrize;
    }

}
