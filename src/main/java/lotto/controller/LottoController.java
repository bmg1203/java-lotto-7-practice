package lotto.controller;

import static lotto.domain.factory.LottoFactory.generateLotto;
import static lotto.domain.factory.ResultFactory.generateResult;
import static lotto.handler.Handler.repeatInputUntilValid;
import static lotto.util.ProfitCalculator.calculateProfit;
import static lotto.view.InputView.getUserInput;
import static lotto.view.InputView.getUserInputByList;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Prize;
import lotto.domain.Purchase;
import lotto.domain.Result;

public class LottoController {
    private LottoMachine lottoMachine;

    public LottoController() {
        lottoMachine = new LottoMachine();
    }

    public void start() {
        Purchase purchase = repeatInputUntilValid(() -> new Purchase(getUserInput()));

        List<Lotto> lottos = generateLotto(purchase);

        repeatInputUntilValid(() -> lottoMachine.assignWinningNumbers(getUserInputByList()));
        repeatInputUntilValid(() -> lottoMachine.assignBonusNumber(getUserInput()));

        Result lottoResult = generateResult(lottoMachine, lottos);

        Prize prize = lottoResult.getTotalPrize();

        double profit = calculateProfit(prize, purchase);
    }
}
