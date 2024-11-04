package lotto.config;

import java.util.List;
import lotto.model.Lotto;
import lotto.view.*;
import lotto.controller.*;
import lotto.validator.PaymentValidator;

public class LottoFactory {
    private final Purchasing_InputView purchasingInputView;
    private final PaymentValidator paymentValidator;
    private final Purchasing_OutputView purchasingOutputView;
    private final Publishing_OutputTicketsView publishingOutputTicketsView;
    private final Winning_InputView winningInputView;
    private final Winning_OutputView winningOutputView;

    public LottoFactory() {
        this.purchasingInputView = new Purchasing_InputView();
        this.paymentValidator = new PaymentValidator();
        this.purchasingOutputView = new Purchasing_OutputView();
        this.publishingOutputTicketsView = new Publishing_OutputTicketsView();
        this.winningInputView = new Winning_InputView();
        this.winningOutputView = new Winning_OutputView();
    }

    public void create() {
        PurchasingController purchasingController = new PurchasingController(purchasingInputView, paymentValidator,
                purchasingOutputView);
        int numberOfTickets = purchasingController.purchaseLottoTickets();

        PublishingController publishingController = new PublishingController(publishingOutputTicketsView, numberOfTickets);
        List<Lotto> LottoTickets = publishingController.publishLottoTickets();

        WinningController winningController = new WinningController(LottoTickets, winningInputView, winningOutputView);
        winningController.presentRanksAndRates();
    }

    private void createPurchasingController() {

    }
}
