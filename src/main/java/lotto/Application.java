package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoSalesController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoSalesController lottoSalesController = new LottoSalesController(inputView, outputView);

        lottoSalesController.run();

        Console.close();
    }
}
