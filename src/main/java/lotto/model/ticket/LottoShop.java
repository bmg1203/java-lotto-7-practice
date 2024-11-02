package lotto.model.ticket;

public class LottoShop {

    private final TicketSeller ticketSeller;

    private LottoShop(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public static LottoShop openShop() {
        LottoMachine lottoMachine = prepareLottoMachine();
        TicketSeller ticketSeller = hireTicketSeller(lottoMachine);
        return new LottoShop(ticketSeller);
    }

    private static LottoMachine prepareLottoMachine() {
        return new LottoMachine();
    }

    private static TicketSeller hireTicketSeller(LottoMachine lottoMachine) {
        return new TicketSeller(lottoMachine);
    }

    public TicketSeller findTicketSeller() {
        return ticketSeller;
    }
}
