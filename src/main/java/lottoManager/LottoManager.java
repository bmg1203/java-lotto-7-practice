package lottoManager;



import java.util.List;

import lotto.PurchasedLotto;
import observer.Observer;
import rank.LottoRank;
import repository.PurchasedLottoRepository;


public class LottoManager {

    private final PurchasedLottoRepository purchasedLottoRepository;

    private final LottoWinningResult lottoWinningResult;


    private LottoManager(PurchasedLottoRepository purchasedLottoRepository, LottoWinningResult lottoWinningResult) {
        this.purchasedLottoRepository = purchasedLottoRepository;
        this.lottoWinningResult = lottoWinningResult;
    }

    public static LottoManager createLottoManager(PurchasedLottoRepository purchasedLottoRepository,
                                                  LottoWinningResult lottoWinningResult) {
        return new LottoManager(purchasedLottoRepository,  lottoWinningResult);
    }


    public void checkWinningNumbers() {

        List<Observer> myAllLotto = purchasedLottoRepository.findMyAllLotto();

        for (Observer myLotto : myAllLotto) {
            LottoRank myLottoRank = ((PurchasedLotto) myLotto).getRank();
            lottoWinningResult.makeLottoResult(myLottoRank);
        }

    }



    public LottoWinningResult getLottoResult() {
        return lottoWinningResult;
    }
}
