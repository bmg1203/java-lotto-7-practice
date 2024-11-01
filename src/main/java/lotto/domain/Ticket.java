package lotto.domain;

import lotto.vo.Money;

public class Ticket {
    private final int ticket;

    private Ticket(int ticket) {
        this.ticket = ticket;
    }

    public static Ticket from(Money money) {
        return new Ticket(publishTicket(money));
    }

    public int getTicket() {
        return ticket;
    }

    private static int publishTicket(Money money) {
        return money.money() / 1_000;
    }
}
