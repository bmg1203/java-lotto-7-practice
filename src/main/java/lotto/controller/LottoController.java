package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.util.ParseUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        OutputView.printInputPurchaseAmountMessage();
        String purchaseAmountInput = InputView.getUserInput();

        OutputView.printInputWinningNumbers();
        String winningNumbersInput = InputView.getUserInput();
        Lotto winningLotto = lottoService.getWinningLotto(winningNumbersInput);


        OutputView.printInputBonusNumber();
        String bonusNumberInput = InputView.getUserInput();

        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        int lottoCount = purchaseAmount % 1000;
        List<Lotto> lottos = lottoService.generateLottos(lottoCount);
        Map<Integer, Integer> matchCounts = lottoService.getMatchCounts(lottos, winningLotto);

    }
}
