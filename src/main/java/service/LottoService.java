package service;


import java.util.List;
import lotto.Lotto;


import lottoManager.LottoWinningResult;

import observer.Observer;
import winningLottoNumber.WinningLottoNumber;

public interface LottoService {


    long calculateBuyQuantity(long buyPrice);


    void buyLotto(long buyQuantity);


    List<Observer> getPurchasedLotto();


    Lotto createWinningLotto(String winningNumbersInput);


    WinningLottoNumber createWinningLottoWithBonus(Lotto winningLottoNumbers, String bonusNumberInput);

    LottoWinningResult getLottoResult();

}

