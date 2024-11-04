package lotto.model;

import lotto.policy.MoneyPolicy;
import lotto.policy.MoneyPolicyImpl;

public class Money {
    private final MoneyPolicy moneyPolicy;
    private String money;

    public Money(String userInputMoney) {
        moneyPolicy = new MoneyPolicyImpl();

        moneyPolicy.checkMoneyPolicy(userInputMoney);
        this.money = userInputMoney;
    }


    public String getMoney() {
        return money;
    }
}
