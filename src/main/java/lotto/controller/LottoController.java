package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResultStatistics;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private LottoOutputView lottoOutputView;
    private LottoInputView lottoInputView;

    public LottoController(LottoOutputView lottoOutputView, LottoInputView lottoInputView) {
        this.lottoOutputView = lottoOutputView;
        this.lottoInputView = lottoInputView;
    }

    public void run() {
        int lottoAmount = lottoInputView.inputPurchaseAmount();
        int numberOfTickets = lottoOutputView.outputNumberOfLottoOutput(lottoAmount);
        List<Lotto> purchasedLottos = Lotto.makeRandomLottos(numberOfTickets);
        lottoOutputView.outputMakeRandomLottos(numberOfTickets);

        Lotto winningNumbers = lottoInputView.inputWinningNumbers();
        List<Integer> winningNumberList = winningNumbers.lottoNumbers();

        int bonusNumber = lottoInputView.inputBonusNumber();

        LottoResultStatistics statistics = new LottoResultStatistics();
        statistics.setTotalExpense(lottoAmount);
        statistics.analyze(purchasedLottos, winningNumberList, bonusNumber);

        lottoOutputView.outputResultStatistics(statistics);
    }
}
