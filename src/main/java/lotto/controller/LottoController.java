package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoNumbers;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.LottoTickets;
import lotto.model.PurchasePrice;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;


    public LottoController(final LottoService lottoService, final InputView inputView, final OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchasePrice purchasePrice = requestWithRetry(this::requestPurchasePrice);
        respondPurchaseQuantity(purchasePrice);

        LottoTickets lottoTickets = lottoService.generateLottoTickets(purchasePrice);
        respondLottoTickets(lottoTickets);

        WinningNumbers winningNumbers = requestWithRetry(this::requestWinningNumbers);
        respondWinningResult(lottoTickets, winningNumbers, purchasePrice);
    }

    private PurchasePrice requestPurchasePrice() {
        outputView.displayPurchasePriceRequest();
        return new PurchasePrice(inputView.getInteger());
    }

    private void respondPurchaseQuantity(final PurchasePrice purchasePrice) {
        outputView.displayPurchaseQuantity(purchasePrice.calculateQuantity());
    }

    private void respondLottoTickets(final LottoTickets lottoTickets) {
        List<LottoNumbers> lottoNumbers = lottoTickets.tickets().stream()
                .map(LottoNumbers::of)
                .toList();
        outputView.displayLottoNumbers(lottoNumbers);
    }

    private WinningNumbers requestWinningNumbers() {
        Lotto mainNumbers = requestMainNumbers();
        BonusNumber bonusNumber = requestBonusNumber(mainNumbers);
        return new WinningNumbers(mainNumbers, bonusNumber);
    }

    private Lotto requestMainNumbers() {
        outputView.displayMainNumbersRequest();
        String mainNumbers = inputView.getString();
        return lottoService.createMainNumbers(mainNumbers);
    }

    private BonusNumber requestBonusNumber(Lotto mainNumbers) {
        outputView.displayBonusNumberRequest();
        int bonusNumber = inputView.getInteger();
        return BonusNumber.of(bonusNumber, mainNumbers);
    }

    private void respondWinningResult(
            final LottoTickets lottoTickets,
            final WinningNumbers winningNumbers,
            final PurchasePrice purchasePrice
    ) {
        Map<Prize, Integer> result = lottoTickets.aggregateWinningResult(winningNumbers);
        double rateOfReturn = lottoService.calculateRateOfReturn(result, purchasePrice);
        outputView.displayWinningResult(result, rateOfReturn);
    }

    private <T> T requestWithRetry(SupplierWithException<T> request) {
        try {
            return request.get();
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e.getMessage());
            return requestWithRetry(request);
        }
    }

    @FunctionalInterface
    private interface SupplierWithException<T> {
        T get() throws IllegalArgumentException;
    }
}
