package lotto.controller;

import java.util.List;
import lotto.model.lotto.LottoResult;
import lotto.model.lotto.Lottos;
import lotto.model.winning.WinningNumbers;
import lotto.model.rank.RankResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int count = getPurchaseCount();
        Lottos lottos = lottoService.generateLottos(count);
        OutputView.printLottos(count, lottos);

        List<Integer> numbers = getNumbersInput();
        int bonusNumber = getBonusNumberInput(numbers);

        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);
        List<LottoResult> lottoResults = lottoService.createResultChecker(winningNumbers).check(lottos);

        RankResult rankResult = lottoService.checkRanks(lottoResults);
        OutputView.printRankResult(rankResult);

        double totalPrize = lottoService.calculateTotalPrize(rankResult);
        double profitRate = lottoService.calculateRateOfReturn(count, totalPrize);
        OutputView.printRateOfReturn(profitRate);
    }

    private int getPurchaseCount() {
        while (true) {
            try {
                String amount = InputView.readAmount();
                return lottoService.getPurchaseCount(amount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> getNumbersInput() {
        while (true) {
            try {
                List<String> numbersInput = InputView.readNumbers();
                return lottoService.getNumbers(numbersInput);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumberInput(List<Integer> numbers) {
        while (true) {
            try {
                String bonusInput = InputView.readBonusNumber();
                return lottoService.getBonusNumber(bonusInput, numbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
