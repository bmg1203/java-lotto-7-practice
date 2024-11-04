package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        try {
            int amount = inputAmount();
            List<Lotto> purchasedLottos = purchaseLottos(amount / LOTTO_PRICE);
            printLottos(purchasedLottos);
            List<Integer> winningNumbers = inputWinningNumbers();
            int bonusNumber = inputBonusNumber();
            printResult(calculateResults(purchasedLottos, winningNumbers, bonusNumber), amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int inputAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int amount = Integer.parseInt(Console.readLine());
                if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식의 금액을 입력해 주세요."); // 숫자 형식이 아닌 경우 처리
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 1000원 단위가 아닌 경우 처리
            }
        }
    }

    private static List<Lotto> purchaseLottos(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    private static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 번호 입력 메서드 - 유효성 검사는 Lotto 클래스에서 처리
    private static List<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                String input = Console.readLine();
                String[] inputs = input.split(",");
                List<Integer> winningNumbers = new ArrayList<>();
                for (String num : inputs) {
                    winningNumbers.add(Integer.parseInt(num.trim()));
                }
                return winningNumbers;
            } catch (Exception e) {
                System.out.println("[ERROR] 올바른 형식의 당첨 번호를 입력해 주세요.");
            }
        }
    }

    // 보너스 번호 입력 메서드 - 유효성 검사는 Lotto 클래스에서 처리
    private static int inputBonusNumber() {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 형식의 보너스 번호를 입력해 주세요.");
            }
        }
    }

    private static int[] calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] results = new int[Rank.values().length];
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean matchBonus = lotto.containsBonusNumber(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            results[rank.ordinal()]++;
        }
        return results;
    }

    private static void printResult(int[] results, int amount) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", results[Rank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", results[Rank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", results[Rank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", results[Rank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", results[Rank.FIRST.ordinal()]);

        double rateOfReturn = calculateRateOfReturn(results, amount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }

    private static double calculateRateOfReturn(int[] results, int amount) {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += results[rank.ordinal()] * rank.getPrize();
        }
        return (double) totalPrize / amount * 100;
    }
}