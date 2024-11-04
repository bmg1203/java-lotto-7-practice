package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Long money = inputMoney();
        Long countLotto = availableLotto(money);

        List<List<Integer>> lottoList = lottoRandom(countLotto);
        haveLotto(lottoList);

        Lotto lotto = new Lotto(prizeNumbers());
        int bonusNum = lotto.bonusNumber(inputBonus());

        Map<Integer, Long> prizeMap = new HashMap<>();
        for (int i = 0; i <= 7; i++) {
            prizeMap.put(i, 0L);
        }

        checkPrize(prizeMap, lottoList, lotto.numbersList(), bonusNum);
        printPrize(prizeMap);

        Long income = incomeCalculation(prizeMap);
        rateCalculation(money, income);
    }

    public static Long inputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        Long money = Long.parseLong(Console.readLine());
        if (validateMoney(money)) {
            return money;
        }
        return inputMoney();
    }

    public static boolean validateMoney(Long money) {
        return money % 1000 == 0;
    }

    public static List prizeNumbers() {
        List<Integer> finalList = new ArrayList<>();

        while (true) {
            List<Integer> numberList = new ArrayList<>();
            boolean validate = inputNumber(numberList);
            if (validate) {
                finalList = numberList;
                break;
            }
        }

        return finalList;
    }

    public static boolean inputNumber(List<Integer> NumberList) {
        System.out.println("당첨번호를 입력해주세요.");
        String winNumbers = Console.readLine();

        for (String num : winNumbers.split(",", -1)) {
            if (!validateNumber(num)) {
                return false;
            }
            NumberList.add(Integer.parseInt(num));
        }
        return true;
    }

    public static int inputBonus() {
        System.out.println("보너스 번호를 입력해주세요.");
        String number = Console.readLine();

        if (!validateNumber(number)) {
            return inputBonus();
        }
        return Integer.parseInt(number);
    }

    public static boolean validateNumber(String num) {
        if (num.isBlank()) {
            return false;
        }

        if (!Pattern.matches("^[0-9]*$", num)) {
            return false;
        }

        if (Integer.parseInt(num) < 1) {
            return false;
        }

        if (45 < Integer.parseInt(num)) {
            return false;
        }

        return true;
    }

    public static Long availableLotto(Long money) {
        Long countLotto = money / 1000;
        System.out.println(countLotto + "개를 구매했습니다.");
        return countLotto;
    }

    public static List<List<Integer>> lottoRandom(Long countLotto) {
        List<List<Integer>> lottoList = new ArrayList<>();

        for (long i = 0; i < countLotto; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(lottoNumbers);
        }
        return lottoList;
    }

    public static void haveLotto(List<List<Integer>> lottoList) {
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void checkPrize(Map<Integer, Long> prizeMap, List<List<Integer>> lottoList, List<Integer> numbersList,
                                  int bonus) {
        for (List<Integer> lotto : lottoList) {
            boolean checkBonus = lotto.contains(bonus);
            lotto.retainAll(numbersList);

            if (checkBonus && (lotto.size() == 5)) {
                amountPrize(prizeMap, 7);
                continue;
            }

            amountPrize(prizeMap, lotto.size());
        }
    }

    public static void amountPrize(Map<Integer, Long> prizeMap, int count) {
        for (Map.Entry<Integer, Long> entry : prizeMap.entrySet()) {
            if (entry.getKey() == count) {
                prizeMap.put(entry.getKey(), entry.getValue() + 1);
            }
        }

    }

    public static void printPrize(Map<Integer, Long> prizeMap) {
        System.out.println("3개 일치 (5,000원) - " + prizeMap.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeMap.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeMap.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeMap.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeMap.get(6) + "개");
    }

    public static Long incomeCalculation(Map<Integer, Long> prizeMap) {
        Long income;

        income = 5000L * prizeMap.get(3).longValue();
        income += 50000L * prizeMap.get(4).longValue();
        income += 1500000L * prizeMap.get(5).longValue();
        income += 30000000L * prizeMap.get(7).longValue();
        income += 2000000000L * prizeMap.get(6).longValue();

        return income;
    }

    public static void rateCalculation(Long money, Long income) {
        double rate = ((double) income / (double) money) * 100L;
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }

}
