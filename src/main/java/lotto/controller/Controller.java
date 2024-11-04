package lotto.controller;

import static lotto.utils.Constants.THOUSAND_VALUE;

import java.util.List;
import lotto.domain.WinnerResult;
import lotto.service.LottoCalculator;
import lotto.service.RandomLotteryGenerator;
import lotto.domain.LottoGroup;
import lotto.domain.Player;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Player player = buyLottoTickets();
        LottoGroup lottoGroup = generateLotto(player);
        WinningLotto winningLotto = setUpWinningNumber();
        findWinningTicketsAndPrintResult(lottoGroup, winningLotto, player);
    }

    private Player buyLottoTickets() {
        int money = inputView.inputMoneyAmount();
        int quantity = money / THOUSAND_VALUE;
        outputView.printBoughtAmount(quantity);

        return new Player(money, quantity);
    }

    private LottoGroup generateLotto(Player player) {
        RandomLotteryGenerator randomLotteryGenerator = new RandomLotteryGenerator();
        LottoGroup lottoGroup = randomLotteryGenerator.generateLottoGroup(player.getTicketQuantity());
        outputView.printLottoGroup(lottoGroup);

        return lottoGroup;
    }

    private WinningLotto setUpWinningNumber() {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        return new WinningLotto(winningNumbers, bonusNumber, new WinnerResult());
    }

    private void findWinningTicketsAndPrintResult(LottoGroup lottoGroup, WinningLotto winningLotto, Player player) {
        outputView.printWinningStatics();
        winningLotto.findWinningLottery(lottoGroup, winningLotto);
        outputView.printTotal(winningLotto.getWinnerResult());
        outputView.printFinalRate(
                LottoCalculator.calculateFinalRate(winningLotto.getWinnerResult(), player.getMoney()));
    }
}
