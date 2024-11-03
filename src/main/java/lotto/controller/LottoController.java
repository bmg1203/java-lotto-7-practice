package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.LottoWinningTierManager;
import lotto.service.LottoService;
import lotto.service.Validate;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();
    private final Validate validate = new Validate();
    private List<Lotto> purchaseLottoNumbers;
    private LottoWinningNumbers lottoWinningNumbers;
    private LottoWinningTierManager lottoWinningTierManager;

    public void setPurchaseLottoNumbers () {
        while (true) {
            try {
                String purchaseAmount = inputView.requestPurchaseAmount();
                purchaseLottoNumbers = lottoService.purchaseLotto(
                        validate.validatePurchaseAmount(purchaseAmount));
                lottoService.sortPurchaseLotto(purchaseLottoNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
    public void printPurchaseLottoNumbers () {
        outputView.printPurchasedLottoCount(purchaseLottoNumbers.size());
        for (Lotto lotto : purchaseLottoNumbers) {
            outputView.printMessage(lotto.getNumbers().toString());
        }
    }

    public void setWinningNumbers () {
        List<Integer> winningNumbers = initializeWinningNumbers();
        lottoWinningNumbers = new LottoWinningNumbers(
                winningNumbers,
                initializeBonusNumber(winningNumbers));
    }
    private List<Integer> initializeWinningNumbers () {
        while (true) {
            try {
                String winningNumbersInput = inputView.requestWinningNumbers();
                return validate.validateWinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
    private int initializeBonusNumber (List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = inputView.requestBonusNumber();
                return validate.validateBonusNumber(bonusNumberInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public void verifyLottoResults() {
        lottoWinningTierManager = new LottoWinningTierManager();
        lottoService.updateWinningStatus(lottoWinningTierManager, purchaseLottoNumbers, lottoWinningNumbers);
    }

    public void printResult () {
        outputView.printStartWinResult();
        outputView.printLottoPlace(lottoWinningTierManager);
        outputView.printTotalProfitRate(checkTotalProfitRate());
    }
    public double checkTotalProfitRate () {
        return lottoService.calculateTotalProfitRate(
                lottoWinningTierManager,
                purchaseLottoNumbers.size() * 1000);
    }
}
