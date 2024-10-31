package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String purchaseAmount;
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Console.readLine();

        int purchaseAmountInt = validatePurchaseAmount(purchaseAmount);

        List<Integer> lotto = pickLottoNumber();
        lotto = sortAscendingInteger(lotto);

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
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수여야합니다");
        }
        if (purchaseAmountInt <= 0 || purchaseAmountInt %1000 > 0 ) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야합니다.");
        }

        return purchaseAmountInt;
    }
}
