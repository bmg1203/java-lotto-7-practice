package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.validate.BonusNumberValidate;
import lotto.validate.LottoNumberValidate;
import lotto.validate.PriceValidate;
import lotto.view.OutputView;

import java.util.List;

import static lotto.view.InputView.*;

public class InputService {

    private int priceValidate() {
        PriceValidate validate = new PriceValidate(inputLottoMoney());
        return validate.getPrice();
    }

    public User inputUser() {
        User user = new User(priceValidate());
        OutputView.buyLottoQuantity(user);
        OutputView.buyLottoNumber(user);
        return user;
    }

    private List<Integer> lottoNumberValidate() {
        LottoNumberValidate validate = new LottoNumberValidate(inputLottoNumber());
        return validate.getLottoNumber();
    }

    private int bonusNumberValidate() {
        BonusNumberValidate validate = new BonusNumberValidate(inputBonusNumber());
        return validate.getBonusNumber();
    }

    public Lotto setWinningLotto() {
        Lotto lotto = new Lotto(lottoNumberValidate());
        lotto.setBonusNumber(bonusNumberValidate());
        return lotto;
    }
}
