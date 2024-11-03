package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> splitLottoNumbers(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : input.split(",")) {
            try {
                lottoNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호를 다시 확인해 주세요.");
            }
        }
        return lottoNumbers;
    }

    public static int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> userNumbers) {
        int count = 0;
        for (int userNumber : userNumbers) {
            if (lottoNumbers.contains(userNumber)) {
                count++;
            }
        }
        return count;
    }

    public static boolean calculateBonusMatch(int matchCount, int bonusNumber, List<Integer> userNumbers) {
        if (matchCount == 5) {
            return userNumbers.contains(bonusNumber);
        }
        return false;
    }

    public static int calculateProfit(int prize, int count) {
        return prize * count;
    }

    public static double calculateProfitRate(int profit, int money) {
        return (double) profit / money * 100;
    }
}
