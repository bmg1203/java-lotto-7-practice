package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.validation.Validation.*;

public class Consumer {

    private final static int MAX_COST = 100000;
    private final static int MIN_COST = 1000;

    private final int money;

    public Consumer(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        checkMoneyMinCost(money, MIN_COST);
        checkMoneyMaxCost(money, MAX_COST);
    }

    public int getMoney() {
        return money;
    }

}
