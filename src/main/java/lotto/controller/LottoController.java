package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        lottoService = new LottoService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        int lottoPriceInt = inputView.inputLottoPrice();

        int lottoNum = lottoService.purchaseLotto(lottoPriceInt);
        List<Lotto> lotto = lottoService.randomLottoNum(lottoNum);
        outputView.printLotto(lotto, lottoNum);

        String lottoWinningNumbers = inputView.inputLottoWinningNumbers();
        List<Integer> winningNumbers = lottoService.splitLottoWinningNumbers(lottoWinningNumbers);

        int bonusNumber = inputView.inputLottoBonusNumber();
        LottoWinningNumbers winningNumbersSet = lottoService.winningLotto(winningNumbers, bonusNumber);

        LottoResult resultWinningLotto = lottoService.resultWinningLotto(winningNumbersSet, lottoNum);
        LottoResult result = lottoService.calculateRate(resultWinningLotto, lottoPriceInt);

        outputView.totalLotto(result);
    }
}
