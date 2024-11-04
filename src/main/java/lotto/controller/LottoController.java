package lotto.controller;

import lotto.model.UserLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    LottoService lottoService = new LottoService();
    UserLotto userLotto = new UserLotto();

    public void run() {
        String purchaseAmount = InputView.readPurchaseAmount();
        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);
        List<String> purchasedLottoNumber = lottoService.purchaseLotto(lottoCount);
        OutputView.printPurchasedLotto(lottoCount, purchasedLottoNumber);

        String userNumber = InputView.readUserNumber();
        userLotto.setNumbers(userNumber);

        String bonusNumber = InputView.readBonusNumber();
        userLotto.setBonusNumber(bonusNumber);

        lottoService.matchLotto(userLotto);
        OutputView.printWinningResult();
    }
}
