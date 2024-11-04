package lotto;

import java.util.List;
import observer.Observer;
import rank.LottoRank;

public class PurchasedLotto implements Observer {
    private final Lotto myLotto;
    private LottoRank rank;

    private PurchasedLotto(Lotto myLotto) {
        this.myLotto = myLotto;
    }


    public static PurchasedLotto createPurchasedLotto(Lotto myLotto) {
        return new PurchasedLotto(myLotto);
    }

    public Lotto getMyLotto() {
        return myLotto;
    }


    @Override
    public void update(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = calculateMatchCount(winningNumbers);
        boolean bonusMatch = isBonusMatch(bonusNumber);
        this.rank = LottoRank.valueOf(matchCount, bonusMatch);  // 등수를 상태로 설정

    }


    private boolean isBonusMatch(int bonusNumber) {
        List<Integer> lottoNumbers = myLotto.getLottoNumbers();
        return lottoNumbers.contains(bonusNumber);
    }


    private int calculateMatchCount(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : myLotto.getLottoNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }


    public LottoRank getRank() {
        return rank;
    }
}