package lotto.service;

import lotto.validator.BonusNumValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningNumValidator;
import lotto.view.InputView;

public class LottoService {
    private final InputView inputView;

    public LottoService(InputView inputView) {
        this.inputView = inputView;
    }

    public void init(){
        String money = inputView.readMoney();
        new MoneyValidator().validate(money);

        String winningNum=inputView.readLottoNum();
        new WinningNumValidator().validate(winningNum);

        String bonusNum = inputView.readBonusNum();
        new BonusNumValidator().validate(bonusNum);
    }
}
