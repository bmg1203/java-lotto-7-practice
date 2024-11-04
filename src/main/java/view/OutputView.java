package view;

import java.util.List;

import lottoManager.LottoWinningResult;
import observer.Observer;


public interface OutputView {

    void showQuantityView(long buyQuantity);


    void showMyPurchasedLotto(List<Observer> myWholeLotto);


    void displayFinalResult(LottoWinningResult result, long buyQuantity);


}
