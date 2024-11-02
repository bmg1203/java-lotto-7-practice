package lotto;
import java.util.Map;

public class LottoResultPrinter {

    public static void printResults(Map<PrizeRank, Integer> resultCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int totalPrize = 0;
        for (PrizeRank rank : PrizeRank.values()) {
            int count = resultCounts.getOrDefault(rank, 0);
            totalPrize += count * rank.getPrize();
            System.out.printf("%s - %d개\n", rank.getLabel(), count);
        }

        printYield(totalPrize, calculateTotalAmountSpent(resultCounts));
    }

    private static void printYield(int totalPrize, int totalAmountSpent) {
        double yield = (double) totalPrize / totalAmountSpent * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    private static int calculateTotalAmountSpent(Map<PrizeRank, Integer> resultCounts) {
        int totalTickets = 0;
        for (int count : resultCounts.values()) {
            totalTickets += count;
        }
        return totalTickets * 1000; // 로또 한 장당 1,000원
    }
}

