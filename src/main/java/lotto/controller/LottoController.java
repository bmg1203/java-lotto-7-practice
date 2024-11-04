package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static List<Lotto> myLottos = new ArrayList<>();

    public void play() {
        OutputView.printAskMoneyMessage();
        Money money = new Money(InputView.inputMoney());
        buyLottos(money.trial);
    }

    public void buyLottos(int trial) {
        OutputView.printNoticeTrialMessage(trial);
        do {
            List<Integer> numbers = LottoNumber.pickRandomNumbers(6);
            myLottos.add(new Lotto(numbers));
        } while (myLottos.size() < trial);
        OutputView.printBoughtLottos(myLottos);
    }
}
