package service;

import calculator.QuantityCalculator;

import java.util.List;
import lotto.Lotto;
import lotto.PurchasedLotto;
import lottoFactory.LottoFactory;
import lottoManager.LottoManager;
import lottoManager.LottoWinningResult;
import observer.Observer;
import repository.PurchasedLottoRepository;
import repository.WinningNumberRepository;
import winningLottoNumber.BonusNumber;
import winningLottoNumber.WinningLottoNumber;


public class LottoServiceImpl implements LottoService {

    private final PurchasedLottoRepository purchasedLottoRepository;
    private final WinningNumberRepository winningNumberRepository;
    private final LottoWinningResult lottoWinningResult;



    public LottoServiceImpl(PurchasedLottoRepository purchasedLottoRepository,
                            WinningNumberRepository winningNumberRepository,
                            LottoWinningResult lottoWinningResult) {
        this.purchasedLottoRepository = purchasedLottoRepository;
        this.winningNumberRepository = winningNumberRepository;
        this.lottoWinningResult = lottoWinningResult;
    }


    public long calculateBuyQuantity(long buyPrice) {

        return QuantityCalculator.calculateBuyQuantity(buyPrice);

    }


    public void buyLotto(long buyQuantity) {
        for (long i = 0; i < buyQuantity; i++) {
            PurchasedLotto purchasedLotto = LottoFactory.createLotto();
            purchasedLottoRepository.saveMyLotto(purchasedLotto);
        }
    }


    public List<Observer> getPurchasedLotto() {

        return purchasedLottoRepository.findMyAllLotto();
    }


    public Lotto createWinningLotto(String winningNumbersInput) {
        winningNumberRepository.makeWinningNumbers(winningNumbersInput);
        List<Integer> winningLottoNumbers = winningNumberRepository.findWinningLotto();
        return new Lotto(winningLottoNumbers);
    }



    public WinningLottoNumber createWinningLottoWithBonus(Lotto winningLottoNumbers, String bonusNumberInput) {

        BonusNumber bonusNumber = BonusNumber.createBonusNumber(bonusNumberInput);

        WinningLottoNumber winningLottoNumber = WinningLottoNumber.createWinningLotto(winningLottoNumbers, bonusNumber);

        winningLottoNumber.addObserver( purchasedLottoRepository.findMyAllLotto());
        winningLottoNumber.confirmWinningNumbers();


        return winningLottoNumber;
    }


    public LottoWinningResult getLottoResult() {
        LottoManager lottoManager = LottoManager.createLottoManager(purchasedLottoRepository, lottoWinningResult);
        lottoManager.checkWinningNumbers();
        return lottoManager.getLottoResult();
    }


}
