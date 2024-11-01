package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class LotteMachine {
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 45;
    private static final Integer LOTTO_SIZE = 6;
    private final ArrayList<Lotto> purchasedLottoTickets = new ArrayList<>();
    private final Verifier verifier = new Verifier();
    public void run() {
        buyLotto();
        printLottoNumbers();
    }

    public void buyLotto() {
        int purchaseAmount = getPurchaseAmount();
        int purchaseQuantity = getPurchaseQuantity(purchaseAmount);
        // 로또 구입
        for (int i = 0; i < purchaseQuantity; i++) {
            purchasedLottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_SIZE)));
        }
    }

    public void printLottoNumbers() {
        System.out.println();
        System.out.println(purchasedLottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottoTickets) {
            lotto.printLottoNumbers();
        }
        System.out.println();
    }

    public int getPurchaseQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public int getPurchaseAmount() {
        String input;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            input = Console.readLine();
        } while (!verifier.isValidPurchaseAmount(input)); // 올바른 값을 입력받을 때 까지 반복
        return Integer.parseInt(input);
    }
}
