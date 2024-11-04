package lotto.controller;

import lotto.domain.LottoResultStatistic;
import lotto.domain.LottoUniqueGenerator;
import lotto.domain.MyLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }
    public void run() {
        int numberOfLotto = inputView.inputPurchaseAmountGuide();
        MyLotto myLotto = MyLotto.createLottos(numberOfLotto, LottoUniqueGenerator.getLottoUniqueGenerator());

        resultView.printPurchaseLottoInfo(myLotto);

        WinningLotto winningLotto = inputView.inputWinningLotto();
        LottoResultStatistic lottoResultStatistic = myLotto.getResultStatistic(winningLotto);

        resultView.printResult(lottoResultStatistic, numberOfLotto);
    }
}
