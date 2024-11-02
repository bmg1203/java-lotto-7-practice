package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static final int LOTTO_UNIT_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = calculatePurchaseAmount(scanPurchasePrice());

        List<Lotto> lottos = generateLottos(purchaseAmount);
        printLottos(purchaseAmount, lottos);

        Lotto winningNumbers = scanWinningNumbers();
        int bonusNumber = scanBonusNumber(winningNumbers);

        Map<PrizeRank, Integer> prizeRankCounts = getPrizeRankCounts(lottos, winningNumbers, bonusNumber);
        double rateOfReturn = getRateOfReturn(prizeRankCounts, purchaseAmount);

        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeRankCounts.get(PrizeRank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeRankCounts.get(PrizeRank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeRankCounts.get(PrizeRank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeRankCounts.get(PrizeRank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeRankCounts.get(PrizeRank.FIRST) + "개");
        System.out.println("총 수익률은 "+ String.format("%.1f", rateOfReturn) +"%입니다.");
    }

    public static int calculatePurchaseAmount(int purchasePrice) {
        return purchasePrice / LOTTO_UNIT_PRICE;
    }

    public static int scanPurchasePrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                String purchasePriceInput = Console.readLine();
                return Validator.validatePurchasePrice(purchasePriceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Lotto> generateLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public static void printLottos(int purchaseAmount, List<Lotto> lottos) {
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public static Lotto scanWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String[] winningNumbersInput = Console.readLine().split(",");
            List<Integer> winningNumbers = new ArrayList<>();
            try{
                if (winningNumbersInput.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.(쉼표(,)로 구분)");
                }

                for (String winningNumber : winningNumbersInput) {
                    int number = Validator.validateNumber(winningNumber);
                    winningNumbers.add(number);
                }

                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int scanBonusNumber(Lotto winningNumbers) {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try{
                String bonusNumberInput = Console.readLine();
                return Validator.validateBonusNumber(bonusNumberInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Map<PrizeRank, Integer> getPrizeRankCounts(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        Map<PrizeRank, Integer> prizeRankCounts = new HashMap<>();
        for (PrizeRank prizeRank : PrizeRank.values()) {
            prizeRankCounts.put(prizeRank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean isBonusMatch = lotto.isBonusMatch(bonusNumber);
            PrizeRank prizeRank = PrizeRank.getPrizeRank(matchCount, isBonusMatch);
            prizeRankCounts.put(prizeRank, prizeRankCounts.get(prizeRank) + 1);
        }
        return prizeRankCounts;
    }

    public static double getRateOfReturn(Map<PrizeRank, Integer> prizeRankCounts, int purchaseAmount) {
        // 수익률 = 총상금 / 구입금액 * 100
        // 수익률 = 총상금 / (구입개수 * 1000) * 100
        double totalPrizeAmount = 0;
        for (PrizeRank prizeRank : PrizeRank.values()) {
            double prizeAmount = prizeRank.getPrizeAmount();
            int prizeCount = prizeRankCounts.get(prizeRank);
            totalPrizeAmount += prizeAmount * prizeCount;
        }
        return totalPrizeAmount / (purchaseAmount * 1000) * 100;
    }
}
