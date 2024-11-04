package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.service.InputMessageService;
import lotto.service.LottoService;
import lotto.service.OutputMessageService;
import lotto.util.LottoStatistics;
import lotto.view.OutputMessageView;

public class LottoController {

  private final InputMessageService inputMessageService;
  private final OutputMessageService outputMessageService;
  private final OutputMessageView outputMessageView;
  private final LottoService lottoService;

  public LottoController(InputMessageService inputMessageService,
      OutputMessageService outputMessageService, OutputMessageView outputMessageView,
      LottoService lottoService) {
    this.inputMessageService = inputMessageService;
    this.outputMessageService = outputMessageService;
    this.outputMessageView = outputMessageView;
    this.lottoService = lottoService;
  }

  public void run() {
    long purchaseAmount = inputMessageService.enterPurchaseAmountAndValidation();
    long numberOfPurchases = outputMessageService.numberOfPurchases(purchaseAmount);
    outputMessageView.numberOfPurchases(numberOfPurchases);
    List<Lotto> lottos = lottoService.lottoResults(numberOfPurchases);
    outputMessageView.lottoResults(lottos);
    List<Integer> winningNumbers = inputMessageService.enterWinningNumberAndValidation();
    int bonusNumber = inputMessageService.winningNumbersAddBonusNumberAndValidation(winningNumbers);
    Map<LottoPrize, Integer> statistics = lottoService.calculatingWinningStatistics(lottos,
        winningNumbers, bonusNumber);
    outputMessageView.winningStatistics(statistics);
    outputMessageView.rateOfReturn(outputMessageService.rateOfReturn(statistics, purchaseAmount));

  }

}
