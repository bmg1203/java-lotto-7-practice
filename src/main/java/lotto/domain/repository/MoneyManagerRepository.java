package lotto.domain.repository;

import lotto.domain.MoneyManager;

public class MoneyManagerRepository {

    private MoneyManager moneyManager;

    public void add(MoneyManager moneyManager) {
        this.moneyManager = moneyManager;
    }

    public MoneyManager getMoneyManger() {
        if (moneyManager == null) {
            throw new NullPointerException("moneyManger 를 설정 해야합니다.");
        }

        return moneyManager;
    }
}
