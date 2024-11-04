package lotto.controller;

import lotto.domain.BuyingPrice;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.service.BuyingPriceService;
import lotto.service.CreateLottoService;
import lotto.service.WinningCalculateService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void start() {
        outputView.askBuyingPriceView();
        BuyingPrice buyingPrice = new BuyingPrice(inputView.inputBuyingPriceView());
        int lottoNum = BuyingPriceService.returnNumberOfLotto(buyingPrice);
        outputView.responseBuyingQuantity(lottoNum);
        List<Lotto> lottos = CreateLottoService.createRandomLottos(lottoNum);
        outputView.askWinningLotto();
        String winningLottoNumber = inputView.inputLottoNumbersView();
        outputView.askBonusNumber();
        String bonusNumber = inputView.inputBonusNumberView();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, bonusNumber);
        LottoResult lottoResult = new LottoResult(WinningCalculateService.calculateLottoResults(lottos, winningLotto));

    }

}
