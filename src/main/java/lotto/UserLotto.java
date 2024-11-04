package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.ErrorMessages;

public class UserLotto {
    private int price;
    private List<Lotto> lotto;

    public UserLotto(int price) {
        validate(price);
        this.price = price;
        lotto = new ArrayList<>();
    }

    private void validate(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_UNDER_ZERO));
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_NOT_IN_UNITS_OF_1000));
        }
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public List<Lotto> generateLotto() {
        for (int i = 0; i < price / 1000; i++) {

            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.sort(Comparator.naturalOrder());
            lotto.add(new Lotto(lottoNumbers));
        }
        return lotto;
    }
}
