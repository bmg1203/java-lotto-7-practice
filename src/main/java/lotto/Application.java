package lotto;

import lotto.controller.LottoController;
import lotto.view.input.ConsoleInputView;
import lotto.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new ConsoleInputView(), new ConsoleOutputView());
        lottoController.run();
    }
}
