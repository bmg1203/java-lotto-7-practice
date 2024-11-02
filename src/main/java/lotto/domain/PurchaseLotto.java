package lotto.domain;

import static lotto.constant.ErrorMessage.PRICE_INPUT_ERROR;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
    private static final int PRICE = 1_000;
    private static final int LOTTO_NUMBER_RANGE_MIN = 1;
    private static final int LOTTO_NUMBER_RANGE_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Lotto> purchaseLotto;

    public PurchaseLotto() {
        this.purchaseLotto = new ArrayList<>();
    }

    public int setPurchaseCount(int input) {
        if (input % PRICE != 0) {
            throw new IllegalArgumentException(PRICE_INPUT_ERROR.getMessage());
        }

        return input / PRICE;
    }

    public void issueLotto(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            purchaseLotto.add(lotto);
        }
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX, LOTTO_NUMBER_COUNT);
    }

    public String getLottoNumber() {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : purchaseLotto) {
            sb.append(lotto.getNumbers()).append('\n');
        }

        return sb.toString();
    }

    public List<Lotto> getPurchaseLotto() {
        return purchaseLotto;
    }
}
