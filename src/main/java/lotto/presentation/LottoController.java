package lotto.presentation;

import java.util.List;
import lotto.domain.IssuedLotto;
import lotto.domain.LottoResult;
import lotto.dto.LottoStatisticsDto;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;
import lotto.service.LottoService;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = inputView.getValidPurchaseAmount();
        IssuedLotto issuedLotto = lottoService.createIssuedRandomLotto(purchaseAmount);
        outputView.printIssuedLottos(issuedLotto.getIssuedLottos());

        List<Integer> winningNumbers = inputView.getValidWinningNumbers();
        int bonusNumber = inputView.getValidBonusNumber(winningNumbers);
        LottoResult lottoResult = lottoService.createLottoResult(winningNumbers, bonusNumber);

        LottoStatisticsDto lottoStatisticsDto = lottoService.calculateLottoStatistics(lottoResult, issuedLotto);
        outputView.printLottoRateOfProfit(lottoStatisticsDto);
    }
}
