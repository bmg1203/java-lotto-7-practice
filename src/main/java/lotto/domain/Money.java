package lotto.domain;

public class Money {
    private int money;
    private int spentMoney;
    private int earnedMoney;
    private static final int ZER0_MONEY = 0;

    public Money() {
        this(ZER0_MONEY);
    }

    public Money(int money) {
        this.money = money;
    }

    public int getTicket() {
        int ticketCount = money / 1000;
        useMoney(money);
        return ticketCount;
    }

    public int getEarnedMoney() {
        return earnedMoney;
    }

    public int getSpentMoney() {
        return spentMoney;
    }

    public void addMoney(int amount) {
        money += amount;
        earnedMoney += amount;
    }

    private void useMoney(int amount) {
        money -= amount;
        spentMoney += amount;
    }
}
