package lotto;

import lotto.presentation.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.run();
    }
}
