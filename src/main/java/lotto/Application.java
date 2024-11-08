package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoShop;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController lottoController = new LottoController(new InputView(), new OutputView(), new LottoShop());
            lottoController.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
