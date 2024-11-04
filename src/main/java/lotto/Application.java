package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.utils.Parsing;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService(new Validator(),new Parsing());

        LottoController lottoController = new LottoController(inputView, outputView, lottoService);
        lottoController.run();
    }
}
