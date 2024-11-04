package lotto;

import static lotto.LottoMaker.createLotto;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String HOW_MANY_LOTTO_TEMPLATE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS = "당첨번호를 입력해 주세요.";
    private static final String BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";

    public static void setInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static int countNumberOfLotto(int purchaseAmount) {
        int countNumberOfLotto = purchaseAmount / 1000;
        return countNumberOfLotto;
    }

    public static String getHowManyLottoMessage(int numberOfLotto) {
        return String.format(HOW_MANY_LOTTO_TEMPLATE, numberOfLotto);
    }

    public static List<Lotto> giveLotto(int numberOfLotto) {
        List<Lotto> lottoResult = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = createLotto();
            System.out.println(lotto.getNumbers());
            lottoResult.add(lotto);
        }
        return lottoResult;
    }

    public static void setWinningNumbers() {
        System.out.println(WINNING_NUMBERS);
    }

    public static void setBonusNumbers() {
        System.out.println(BONUS_NUMBERS);
    }
}
