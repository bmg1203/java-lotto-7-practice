package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        Money money = new Money(inputView.enterMoney());
        outputView.printTicketAmount(money);

        LottoTicket lottoTicket = new LottoTicket(money);
        outputView.printLotto(lottoTicket);

        final String originWinningNumber = inputView.enterWinningNumber();
        final Integer bonusNumber = inputView.enterBonusNumber();

        WinningLotto winningLotto = new WinningLotto(convertToLottoFormat(originWinningNumber), bonusNumber);


    }

    public List<Integer> convertToLottoFormat(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
