package lotto;

import lotto.controller.LottoController;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator inputValidator = new InputValidator();
        LottoController lottoController = new LottoController(inputView, outputView, inputValidator);
        lottoController.process();
    }
}
