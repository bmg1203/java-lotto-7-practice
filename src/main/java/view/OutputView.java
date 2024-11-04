package view;

import java.util.List;

import lottoManager.LottoWinningResult;
import observer.Observer;


public interface OutputView {

    void showQuantityView(int buyQuantity);


    void showMyPurchasedLotto(List<Observer> myWholeLotto);


    void displayFinalResult(LottoWinningResult result, int buyQuantity);


}
