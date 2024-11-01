package lotto.controller;

import static lotto.view.OutputView.printLottoExceptionMessage;
import static lotto.view.OutputView.printLottoGroup;
import static lotto.view.OutputView.printNewLine;
import static lotto.view.OutputView.printPurchaseMessage;
import static lotto.view.OutputView.printReturnRate;
import static lotto.view.OutputView.printWinningStatsTitle;
import static lotto.view.OutputView.printWinningSummary;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.domain.Revenue;
import lotto.domain.WinningNumbers;
import lotto.dto.WinningStat;
import lotto.dto.WinningSummary;
import lotto.exception.LottoException;
import lotto.service.BuyerService;
import lotto.service.LottoService;
import lotto.service.StatService;
import lotto.utils.WinningSummaryGenerator;
import lotto.view.InputView;

public class LottoGameController {
    private final BuyerService buyerService;
    private final LottoService lottoService;
    private final StatService statService;

    public LottoGameController(BuyerService buyerService, LottoService lottoService, StatService statService) {
        this.buyerService = buyerService;
        this.lottoService = lottoService;
        this.statService = statService;
    }

    public void run() {
        final LottoGame lottoGame = setLottoGame();
        final WinningSummary winningSummary = getWinningSummary(lottoGame);

        getReturnRate(lottoGame, winningSummary);
    }

    private LottoGame setLottoGame() {
        final Lottos lottos = purchaseLotto();
        final WinningNumbers winningNumbers = getWinningNumbers();
        final BonusNumber bonusNumber = getBonusNumber(winningNumbers);

        Console.close();

        return lottoService.createLottoGame(lottos, winningNumbers, bonusNumber);
    }

    private Lottos purchaseLotto() {
        final int lottoQuantity = getLottoQuantity();
        return getLottos(lottoQuantity);
    }

    private int getLottoQuantity() {
        String input = InputView.inputPurchaseAmount();

        try {
            int lottoQuantity = buyerService.calculateLottoQuantity(input);
            printPurchaseMessage(lottoQuantity);

            return lottoQuantity;
        } catch (LottoException e) {
            printLottoExceptionMessage(e);

            return getLottoQuantity();
        }
    }

    private Lottos getLottos(int lottoQuantity) {
        Lottos lottos = lottoService.createLottos(lottoQuantity);
        List<Lotto> lottoGroup = lottos.getLottoGroup();

        printLottoGroup(lottoGroup);

        return lottos;
    }

    private WinningNumbers getWinningNumbers() {
        String input = InputView.inputWinningNumbers();

        try {
            WinningNumbers winningNumbers = buyerService.createWinningNumbers(input);
            printNewLine();

            return winningNumbers;
        } catch (LottoException e) {
            printLottoExceptionMessage(e);

            return getWinningNumbers();
        }
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        String input = InputView.inputBonusNumbers();

        try {
            BonusNumber bonusNumber =  buyerService.createBonusNumber(winningNumbers, input);
            printNewLine();

            return bonusNumber;
        } catch (LottoException e) {
            printLottoExceptionMessage(e);

            return getBonusNumber(winningNumbers);
        }
    }

    private WinningSummary getWinningSummary(LottoGame lottoGame) {
        printWinningStatsTitle();

        return calculateStats(lottoGame);
    }

    private WinningSummary calculateStats(LottoGame lottoGame) {
        List<WinningStat> winningStats = statService.getWinningStats(lottoGame);
        WinningSummary winningSummary = WinningSummaryGenerator.generate(winningStats);

        printWinningSummary(winningSummary);

        return winningSummary;
    }

    private void getReturnRate(LottoGame lottoGame, WinningSummary winningSummary) {
        Revenue revenue = statService.createRevenue(lottoGame.getLottos(), winningSummary.WinningStats());

        printReturnRate(revenue);
    }

}
