package lotto.controller;

import lotto.model.LottoReport;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoContoller {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoContoller(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String purchaseAmount = promptPurchaseAmount();

        outputView.printLottoLogs(lottoService.generateLottoLogs());

        String winningNumbersInput = inputView.inputWinningNumbers();
        String bonusNumberInput = inputView.inputBonusNumber();

        LottoReport lottoReport = lottoService.generateLottoReport(
                purchaseAmount,
                winningNumbersInput,
                bonusNumberInput
        );

        outputView.printWinningReport(lottoReport.winningReport());
        outputView.printProfitRate(lottoReport.profitRate());
    }

    private String promptPurchaseAmount() {
        String purchaseAmount;
        while (true) {
            try {
                purchaseAmount = inputView.inputPurchaseAmount();
                lottoService.purchaseLotto(purchaseAmount);
                break;
            } catch (Exception e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return purchaseAmount;
    }
}
