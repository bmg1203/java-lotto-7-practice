package lotto.controller;

import lotto.model.LottoInfo;
import lotto.model.PriceDataImpl;
import lotto.model.StandardLottoPrice;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        LottoInfo lottoInfo = new LottoInfo(new StandardLottoPrice(), new PriceDataImpl());
        int money = inputMoney();
    }

    private int inputMoney() {
        int money;
        while(true) {
            try{
                money = inputView.inputMoney();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return money;
    }
}
