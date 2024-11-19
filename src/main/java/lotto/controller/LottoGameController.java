package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Purchase;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private Purchase purchase;
    private LottoGenerator lottoGenerator;
    private Lotto winningNumber;
    private Bonus bonus;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        purchaseLottos();
        setWinningNumber();
        getResult();
        Console.close();
    }

    private void purchaseLottos() {
        purchase = inputView.purchaseInput();
        lottoGenerator = new LottoGenerator(purchase);
        outputView.purchasePrint(purchase, lottoGenerator);
    }

    private void setWinningNumber() {
        winningNumber = inputView.winningNumberInput();
        bonus = inputView.bonusInput(winningNumber);
    }

    private void getResult() {
        WinningResult winningResult = new WinningResult(winningNumber, bonus, lottoGenerator, purchase);
        outputView.resultPrint(winningResult);
    }
}
