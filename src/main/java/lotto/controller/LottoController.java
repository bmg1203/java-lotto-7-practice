package lotto.controller;

import static lotto.utils.Parser.parse;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.exception.LottoException;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        Lottos lottos = buyLotto();
        showResult(lottos);
        Lotto winnerLotto = getWinnerNumbers();
        LottoMachine lottoMachine = createLottoMachine(winnerLotto);
        Map<LottoResult, Integer> lottoResult = lottoService.getLottoResult(lottoMachine, lottos);
        printResult(lottoResult, lottos.getPrice());
    }

    private Lottos buyLotto() {
        try {
            int money = InputView.getPurchaseAmount();
            return lottoService.buyLotto(money);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }

    private void showResult(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        OutputView.printLotto(lottoList);
    }

    private Lotto getWinnerNumbers() {
        try {
            String winningNumbers = InputView.getWinningNumbers();
            return lottoService.createWinnerLotto(parse(winningNumbers));
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return getWinnerNumbers();
        }
    }

    private BonusNumber getBonusNumber() {
        try {
            int bonusNumber = InputView.getBonusNumber();
            return lottoService.createBonusNumber(bonusNumber);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    private LottoMachine createLottoMachine(Lotto winnerLotto) {
        try {
            BonusNumber bonusNumber = getBonusNumber();
            return lottoService.createLottoMachine(winnerLotto, bonusNumber);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return createLottoMachine(winnerLotto);
        }
    }

    private void printResult(Map<LottoResult, Integer> result, int money) {
        OutputView.printLottoResult(result, money);
    }
}
