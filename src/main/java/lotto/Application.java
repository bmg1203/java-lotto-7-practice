package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoMachine lottoMachine = new LottoMachine();
        Parser parser = new Parser();
        LottoController lottoController = new LottoController(inputView, outputView, lottoMachine, parser);

        lottoController.run();
    }
}
