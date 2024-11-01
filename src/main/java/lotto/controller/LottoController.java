package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.FilterConfig;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private static final String DELIMITER = ",";

    private final LottoService lottoService;
    private final OutputView outputView;
    private final FilterConfig filterConfig = FilterConfig.getInstance();

    public LottoController(LottoService lottoService, OutputView outputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
    }

    public void start() {
        LottoTickets lottoTickets = getPurchasedLottoTickets();
        displayPurchasedTickets(lottoTickets);
        WinningLotto winningLotto = getWinningLotto();
        LottoStatistics lottoStatistics = calculateLottoStatistics(lottoTickets, winningLotto);
        displayStatistics(lottoStatistics);
        Console.close();
    }

    private LottoTickets getPurchasedLottoTickets() {
        outputView.printInputAmountNotice();
        String amountInput = Console.readLine();
        filterConfig.getPositiveIntegerFilterChain().doFilter(amountInput);
        int amount = Integer.parseInt(amountInput);
        return lottoService.purchaseTickets(amount);
    }

    private void displayPurchasedTickets(LottoTickets lottoTickets) {
        outputView.printPurchasedLotto(lottoTickets);
    }

    private WinningLotto getWinningLotto() {
        outputView.printInputWinningLottoNotice();
        String winningLottoInput = Console.readLine();
        filterConfig.getCommaSeparatedNumberFilterChain().doFilter(winningLottoInput);
        List<Integer> winningNumbers = separateInputWinningLotto(winningLottoInput);
        outputView.printInputBonusNumberNotice();
        String bonusNumberInput = Console.readLine();
        filterConfig.getPositiveIntegerFilterChain().doFilter(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private LottoStatistics calculateLottoStatistics(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return lottoService.checkResults(lottoTickets, winningLotto);
    }

    private void displayStatistics(LottoStatistics lottoStatistics) {
        double returnRate = lottoService.calculateProfitRate(lottoStatistics);
        outputView.printLottoStatistics(lottoStatistics, returnRate);
    }

    private List<Integer> separateInputWinningLotto(String winningLottoNumbersInput) {
        return Arrays.stream(winningLottoNumbersInput.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
