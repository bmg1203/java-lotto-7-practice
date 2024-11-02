package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String purchaseAmount;
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Console.readLine();

        int purchaseAmountInt = validatePurchaseAmount(purchaseAmount);

        System.out.println();
        System.out.println(purchaseAmountInt / 1000 + "개를 구매했습니다.");
        for (int i = 0; i < purchaseAmountInt / 1000; i++) {
            List<Integer> lotto = pickLottoNumber();
            lotto = sortAscendingInteger(lotto);
            System.out.println(lotto);
        }

        String inputWinningNumbers;
        System.out.println("\n당첨 번호를 입력해 주세요.");
        inputWinningNumbers = Console.readLine();

        List<String> winningNumbers = List.of(inputWinningNumbers.split(","));
        List<Integer> winningNumbersInteger = stringListToIntegerList(winningNumbers);

    }

    public static List<Integer> stringListToIntegerList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList) {
            intList.add(Integer.parseInt(s));
        }
        return intList;
    }

    public static List<Integer> sortAscendingInteger(List<Integer> integerList) {
        Collections.sort(integerList);
        return integerList;
    }

    public static List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);

    }

    public static int validatePurchaseAmount(String purchaseAmount) {
        int purchaseAmountInt;
        try {
            purchaseAmountInt = Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수여야합니다");
        }
        if (purchaseAmountInt <= 0 || purchaseAmountInt % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야합니다.");
        }

        return purchaseAmountInt;
    }
}
