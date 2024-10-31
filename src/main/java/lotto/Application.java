package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        LottoController controller = new LottoController(inputView, outputView);
        controller.run();
    }
}
