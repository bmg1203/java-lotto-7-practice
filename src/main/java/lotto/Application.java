package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoNumberGenerator;
import lotto.model.NumberStringConverter;
import lotto.model.YieldAnalyst;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView(), new YieldAnalyst(),
                new LottoNumberGenerator(), new NumberStringConverter());

        lottoController.start();
    }
}
