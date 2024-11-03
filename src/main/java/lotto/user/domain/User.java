package lotto.user.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.domain.Lotto;

public class User {
    private final List<Lotto> lottos = new ArrayList<>();
    private int money;

    User(int money) {
        validate(money);

        this.money = money;
    }

    private void validate(int money) {
        if (!UserValidator.OVER_THAN_ZERO.check(money)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 음수일 수 없습니다.");
        }

        if (!UserValidator.MULTIPLE_OF_THOUSAND.check(money)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public boolean canBuyLotto() {
        return money >= Lotto.PRICE;
    }

    public void buy(Lotto lotto) {
        money -= Lotto.PRICE;
        lottos.add(lotto);
    }
}
