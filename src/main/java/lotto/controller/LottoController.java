package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.global.message.InputMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Lottos purchasedLottos = initLotts();
        printPurchaseResult(purchasedLottos);
        WinningNumbers winningNumbers = inputWinningNumbers();
        printLottoResults(purchasedLottos, winningNumbers);
    }

    private Lottos initLotts() {
        try {
            Money money = new Money(InputView.inputNumber(InputMessage.PURCHASE_AMOUNT));
            return new Lottos(money.getLottoQuantity());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return initLotts();
        }
    }

    private void printPurchaseResult(Lottos purchasedLottos) {
        OutputView.printPurchaseResult(purchasedLottos);
    }

    private WinningNumbers inputWinningNumbers() {
        Lotto winnerLotto = inputLotto();
        BonusNumber bonusNumber = inputBonus();
        return new WinningNumbers(winnerLotto, bonusNumber);
    }

    private Lotto inputLotto() {
        try {
            List<Integer> mainWinningNumbers = InputView.inputWinningLotto(InputMessage.WINNING_NUMBERS);
            return new Lotto(mainWinningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputLotto();
        }
    }

    private BonusNumber inputBonus() {
        try {
            long winningBonusNumberInput = InputView.inputNumber(InputMessage.BONUS_NUMBER);
            return new BonusNumber(winningBonusNumberInput);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputBonus();
        }
    }

    private void printLottoResults(Lottos purchasedLottos, WinningNumbers winningNumbers) {
        LottoResult lottoResult = createLottoResult(purchasedLottos, winningNumbers);
        double returnRate = calculateReturnRate(purchasedLottos, lottoResult);
        OutputView.printLottoResults(lottoResult, returnRate);
    }

    private LottoResult createLottoResult(Lottos purchasedLottos, WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResult(purchasedLottos, winningNumbers);
        return lottoResult;
    }

    private double calculateReturnRate(Lottos purchasedLottos, LottoResult lottoResult) {
        return lottoResult.calculateReturnRate(purchasedLottos.getSize() * 1000);
    }
}