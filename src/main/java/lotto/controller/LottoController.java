package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lottery;
import lotto.domain.NumberGenerator;
import lotto.domain.PurchaseLotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final NumberGenerator lottoNumberGenerator;

    public LottoController(NumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        Lottery lottery = prepareLottery();
    }

    private Lottery prepareLottery() {
        OutputView.printPurchaseInputText();
        PurchasePrice purchasePrice = InputView.inputPurchasePrice();
        PurchaseLotto purchaseLotto = createLottoTickets(purchasePrice);

        OutputView.printWinningNumberInputText();
        WinningNumber winningNumber = InputView.inputWinningNumber();

        OutputView.printBonusNumberInputText();
        BonusNumber bonusNumber = InputView.inputBonusNumber(winningNumber);

        return new Lottery(purchaseLotto, winningNumber, bonusNumber);
    }

    private PurchaseLotto createLottoTickets(PurchasePrice purchasePrice) {
        PurchaseLotto purchaseLotto = PurchaseLotto.of(purchasePrice, lottoNumberGenerator);
        OutputView.printPurchasedCount(purchaseLotto);
        OutputView.printPurchasedLottoTickets(purchaseLotto);
        return purchaseLotto;
    }


}
