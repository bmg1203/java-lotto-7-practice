package lotto;

import static lotto.StringPool.MONEY_NOT_DIVIDED_BY_1000;
import static lotto.StringPool.PRINT_SOLD_LOTTO_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoSystem {
    private static LottoCustomer customer = new LottoCustomer();
    private int printLottoCount;

    public List<Lotto> buyLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_BY_1000);
        }
        printLottoCount = money / 1000;
        customer.addBetMoney(money);
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < printLottoCount; ++i) {
            lottos.add(createAutoLotto());
        }
        return lottos;
    }

    public void printSoldLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRINT_SOLD_LOTTO_COUNT);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private Lotto createAutoLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
