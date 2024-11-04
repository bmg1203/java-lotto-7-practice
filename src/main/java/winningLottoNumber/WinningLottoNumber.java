package winningLottoNumber;

import constant.ErrorConst;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import observer.Observer;
import observer.Subject;

public class WinningLottoNumber implements Subject {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    private final List<Observer> observers = new ArrayList<>();


    private WinningLottoNumber(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        validateDuplicateBonusNumber();
    }


    public static WinningLottoNumber createWinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        return new WinningLottoNumber(winningLotto, bonusNumber);
    }


    private void validateDuplicateBonusNumber() {
        if (winningLotto.getLottoNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ErrorConst.ERROR_DUPLICATE_BONUS_NUMBER);
        }
    }



    @Override
    public void addObserver(List<Observer> myPurchasedLotto) {
        for (Observer observer : myPurchasedLotto) {
            observers.add(observer);
        }
    }

    // 당첨번호과 확정되면 모든 옵저버에게 알린다.
    public void confirmWinningNumbers() {
        notifyObservers();  // 정답 번호가 확정된 후 옵저버들에게 알림
    }


    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(winningLotto.getLottoNumbers(),bonusNumber.getBonusNumber());
        }

    }
}
