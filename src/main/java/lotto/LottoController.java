package lotto;

import java.util.List;
import java.util.function.Predicate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public LottoController() {
    }

    public void run() {
        outputView.printInputCashMessage();
        String input = inputView.inputCash();
        Integer cash = lottoService.parseInputToCash(input);
        Integer lottoAmount = lottoService.parseCashToLottoAmount(cash);

        List<Lotto> lottos = lottoService.getLotto(lottoAmount);
        outputView.printLottoAmountMessage(lottoAmount);
        outputView.printLottos(lottos);

        outputView.printInputWinningNumberMessage();
        String winningNumbersInput = inputView.inputWinningNumber();
        Lotto winningLotto = lottoService.parseWinningNumber(winningNumbersInput);

        outputView.printInputBonusNumberMessage();
        String bonusNumberInput = inputView.inputBonusNumber();
        Integer bonusNumber = lottoService.parseBonusNumber(winningLotto, bonusNumberInput);

        Integer price = 0;
        Integer count1st = 0;
        Integer count2nd = 0;
        Integer count3rd = 0;
        Integer count4th = 0;
        Integer count5th = 0;

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> winningNumbers = winningLotto.getNumbers();

            List<Integer> matchNumbers = lottoNumbers.stream().filter(o -> winningNumbers.stream()
                    .anyMatch(Predicate.isEqual(o))).toList();

            if (matchNumbers.size() == 6) {
                price += 2000000000;
                count1st++;
            }
            if (matchNumbers.size() == 5 && lottoService.haveBonusNumber(lottoNumbers, bonusNumber)) {
                price += 30000000;
                count2nd++;
            }
            if (matchNumbers.size() == 5 && !lottoService.haveBonusNumber(lottoNumbers, bonusNumber)) {
                price += 1500000;
                count3rd++;
            }
            if (matchNumbers.size() == 4) {
                price += 50000;
                count4th++;
            }
            if (matchNumbers.size() == 3) {
                price += 5000;
                count5th++;
            }
        }

        Float earningRate = (float) price / cash * 100;

        outputView.printWinningDetail(count1st, count2nd, count3rd, count4th, count5th, earningRate);
    }
}
