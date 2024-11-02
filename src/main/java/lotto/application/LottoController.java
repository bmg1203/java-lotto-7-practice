package lotto.application;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.Lotto;
import lotto.service.LottoNumberGeneratorService;
import lotto.service.LottoTicketBuyingService;
import lotto.service.LottoTicketIssueService;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoController {
    private final InputView inputView;
    private final OutPutView outPutView;
    private static final List<Integer> winningNumbers = new ArrayList<>();

    public LottoController(InputView inputView, OutPutView outPutView) {
        this.inputView = inputView;
        this.outPutView = outPutView;
    }

    public void run() {
        String buyingPrice = inputView.startLottoGameAndReadBuyingPrice();
        Integer lottoTicketAmount = LottoTicketBuyingService.buyingLottoTicket(buyingPrice);
        LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
        LottoTicketIssueService lottoTicketIssueService = new LottoTicketIssueService(lottoTicketAmount,
                lottoNumberGeneratorService);
        List<Lotto> issuedLotto = lottoTicketIssueService.issueLotto();
        outPutView.printBoughtLotto(issuedLotto);
        splitCommaAndConvertToList(inputView.readWinningNumbers());
    }

    private void splitCommaAndConvertToList(String winningNumber) {
        StringTokenizer stringTokenizer = new StringTokenizer(winningNumber, ",");
        while (stringTokenizer.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
    }

}
