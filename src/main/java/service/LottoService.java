package service;


import java.util.List;
import lotto.Lotto;


import lottoManager.LottoWinningResult;

import observer.Observer;
import winningLottoNumber.WinningLottoNumber;

public interface LottoService {


    int calculateBuyQuantity(int buyPrice);


    void buyLotto(int buyQuantity);


    List<Observer> getPurchasedLotto();


    Lotto createWinningLotto(String winningNumbersInput);


    WinningLottoNumber createWinningLottoWithBonus(Lotto winningLottoNumbers, String bonusNumberInput);

    LottoWinningResult getLottoResult();

}

