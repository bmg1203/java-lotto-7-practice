package lotto;

import lotto.controller.PaymentController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        PaymentController paymentController = new PaymentController(inputView, outputView);
    }
}
