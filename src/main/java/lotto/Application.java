package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.PurchaseService;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController(
                new InputView(),
                new PurchaseService(),
                new LottoService()
        );

        lottoController.run();
    }
}
