package lottoFactory;

import java.util.List;
import lotto.Lotto;
import lotto.PurchasedLotto;
import utils.InputUtils;

public class LottoFactory {
    public static PurchasedLotto createLotto() {
        List<Integer> numbers = InputUtils.randomNumbers();
        Lotto lotto = new Lotto(numbers);

        return PurchasedLotto.createPurchasedLotto(lotto);
    }
}
