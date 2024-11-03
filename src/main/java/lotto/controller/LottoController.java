package lotto.controller;

import static lotto.global.exception.ExceptionHandler.getValidInput;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lottoMachine.BonusNumber;
import lotto.domain.lottoMachine.WinningLotto;
import lotto.domain.money.Money;
import lotto.view.View;

public class LottoController {
    private final View view;

    public LottoController(View view) {
        this.view = view;
    }

    public void start() {
        Money money = createMoneyFromUserInput();
        buyLottos(money);

        WinningLotto winningLotto = createWinningLottoFromLottoAndBonusNumber();
//
//        getResults(lottos, winningLotto, bonusNumber);
//        view.outputResult(lottos.match(winningLotto, bonusNumber));
//
//        getProfitRate(money, lottos, winningLotto, bonusNumber);
//        view.outputProfitRate(money, lottos.match(winningLotto, bonusNumber));
    }

    private Money createMoneyFromUserInput() {
        return getValidInput(() -> Money.from(view.inputMoney()));
    }

    private void buyLottos(Money money) {
        Lottos lottos = money.buyLottos();
        view.outputLottos(lottos.getLottos());
    }

    private WinningLotto createWinningLottoFromLottoAndBonusNumber() {
        Lotto lotto = getValidInput(this::createLottoFromUserInput);
        return getValidInput(() -> createWinningLottoFromUserInput(lotto));
    }

    private Lotto createLottoFromUserInput() {
        return Lotto.from(view.inputWinningLotto());
    }

    private WinningLotto createWinningLottoFromUserInput(Lotto lotto) {
        BonusNumber bonusNumber = BonusNumber.from(view.inputBonusNumber());
        return WinningLotto.of(lotto, bonusNumber);
    }

}
