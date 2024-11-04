package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbersCombinations;
import lotto.domain.WinningResult;
import lotto.dto.BonusNumber;
import lotto.dto.LottoResult;
import lotto.dto.PurchaseAmount;
import lotto.dto.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        PurchaseAmount purchaseAmount = getValidLottoPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);
        showLottoNumbers(purchaseAmount, lottos);

        WinningNumbers winningLotto = getWinningNumbers();
        WinningNumbersCombinations winningCombinations = getBonusNumber(winningLotto);

        WinningResult winningResult = new WinningResult(lottos, winningCombinations);
    }

    public PurchaseAmount getValidLottoPurchaseAmount() {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputLottoPurchaseAmount());
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidLottoPurchaseAmount();
        }
    }

    public void showLottoNumbers(PurchaseAmount purchaseAmount, Lottos lottos) {
        LottoResult lottoResult = new LottoResult(
                purchaseAmount.getPurchaseAmount(),
                lottos.displayLottos());
        OutputView.printLottoResult(lottoResult);
    }

    public WinningNumbers getWinningNumbers() {
        try {
            WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    public WinningNumbersCombinations getBonusNumber(WinningNumbers winningNumbers) {
        try {
            BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
            return new WinningNumbersCombinations(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }
}
