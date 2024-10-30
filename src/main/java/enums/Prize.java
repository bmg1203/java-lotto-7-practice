package enums;

import java.text.DecimalFormat;

public enum Prize {
    FIRST("6개 일치", (int) 2e9),
    SECOND("5개 일치, 보너스 볼 일치", (int) 3e7),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000);

    private final String description;
    private final int money;

    Prize(String description, int money) {
        this.description = description;
        this.money = money;
    }

    public String getDescription() {
        DecimalFormat df = new DecimalFormat("#,###");
        String moneyFormat = df.format(money);

        return description + " (" + moneyFormat + ") - ";
    }

    public int getMoney() {
        return money;
    }

}
