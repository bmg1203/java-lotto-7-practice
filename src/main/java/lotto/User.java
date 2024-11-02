package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

import static lotto.Validator.validatePositiveNumber;

public class User {
    private int purchaseAmount;
    private Bag bag;

    public User(int purchaseAmount) {
        validatePositiveNumber(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        bag = new Bag();
    }

    public void buyLotto(Lotto lotto) {
        bag.addLotto(lotto);
    }
    public List<Integer> pickNumbersSorted() {
        List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        pickNumbers.sort(Comparator.naturalOrder());
        return pickNumbers;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public Bag getBag() {
        return bag;
    }


}
