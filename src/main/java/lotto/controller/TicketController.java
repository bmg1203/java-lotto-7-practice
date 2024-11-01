package lotto.controller;

import lotto.ThousandWons;
import lotto.Ticket;
import lotto.usecase.CreateLottoTicketUsecase;
import lotto.usecase.GetLottoTicketUsecase;
import lotto.view.TicketInputView;
import lotto.view.TicketOutputView;

public class TicketController {

    private final TicketInputView inputView;
    private final TicketOutputView outputView;
    private final CreateLottoTicketUsecase createLottoTicketUsecase;
    private final GetLottoTicketUsecase getLottoTicketUsecase;

    public TicketController(TicketInputView inputView,
                            TicketOutputView outputView,
                            CreateLottoTicketUsecase createLottoTicketUsecase,
                            GetLottoTicketUsecase getLottoTicketUsecase) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.createLottoTicketUsecase = createLottoTicketUsecase;
        this.getLottoTicketUsecase = getLottoTicketUsecase;
    }

    //TODO InputView - 구입금액을 입력해 주세요
    //TODO CreateLottoTicketUsecase - 로또티켓을 생성하라
    //TODO GetLottoTicketUsecase - 로또티켓을 조회하라
    //TODO OutputView - { }개를 구매했습니다.
    //TODO OutputView - {로또목록들}

    public Ticket create() {
        ThousandWons krMoney = inputView.initialize();
        Long ticketId = createLottoTicketUsecase.execute(krMoney);
        Ticket ticket = getLottoTicketUsecase.execute(ticketId);
        outputView.showResult(ticket);

        return ticket;
    }
}
