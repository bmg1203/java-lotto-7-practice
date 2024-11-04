package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        processInput();
        lottoService.checkLottoResult();
        printResult();
    }

    private void processInput() {
        continueUntilNormalInput(() -> {
            lottoService.purchaseLotto(inputView.getMoneyInput());
            printPurchasedLotto();
        });
        continueUntilNormalInput(() -> lottoService.setWinningLotto(inputView.getWinningNumbersInput()));
        continueUntilNormalInput(() -> lottoService.setBonusNumber(inputView.getBonusNumberInput()));
    }

    private void continueUntilNormalInput(Runnable processSpecificInput) {
        while (true) {
            try {
                processSpecificInput.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private void printPurchasedLotto() {
        outputView.printMessage(lottoService.purchasedLottoNumbersMessage());
    }

    private void printResult() {
        outputView.printLottoResultHeader();
        lottoService.getResultsOfLotto().forEach(outputView::printMessage);
        outputView.printRateOfReturn(lottoService.getRateOfReturn());
    }
}
