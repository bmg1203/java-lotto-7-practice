package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Issuer;
import lotto.model.LottoResult;
import lotto.model.Statistics;
import lotto.view.ConsoleView;

public class LottoController {
    private final ConsoleView consoleView;
    private final Issuer issuer;
    public LottoController(ConsoleView consoleView, Issuer issuer) {
        this.consoleView = consoleView;
        this.issuer = issuer;
    }

    public void run() {
        Integer purchaseAmount = consoleView.getPurchaseLottoAmount();

        List<Lotto> issuedLottos = issuer.issueLotto(purchaseAmount);
        consoleView.printIssuedLotto(issuedLottos);

        List<Integer> winningNumbers = consoleView.getWinningNumbers();
        Integer bonusNumbers = consoleView.getBonusNumber();

        Statistics statistics = new Statistics(winningNumbers, bonusNumbers);
        Map<LottoResult, Integer> lottoResults = statistics.getResult(issuedLottos);
        System.out.println(lottoResults);
//        consoleView.printStatistics(lottoResults);
    }
}
