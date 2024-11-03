package lotto.controller;


import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoBundle;
import lotto.domain.LottoDispenser;
import lotto.domain.LottoPurchasePrice;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.enums.LottoConfig;
import lotto.handler.RetryHandler;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final RetryHandler retryHandler;
    private final LottoConfig lottoConfig;

    public LottoController(
            LottoInputView lottoInputView,
            LottoOutputView lottoOutputView,
            RetryHandler retryHandler,
            LottoConfig lottoConfig
    ) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.retryHandler = retryHandler;
        this.lottoConfig = lottoConfig;
    }

    public void run() {
        LottoPurchasePrice lottoPurchasePrice = retryHandler.retry(this::requestLottoPurchasePrice);
        LottoBundle lottoBundle = issueLottoBundle(lottoPurchasePrice);
        lottoOutputView.printLottoBundle(lottoBundle);

        WinningLotto winningLotto = retryHandler.retry(this::requestLottoWinningNumbers);
        BonusNumber bonusNumber = retryHandler.retry(this::requestLottoBonusNumber, winningLotto);
        LottoResult lottoResult = lottoBundle.makeLottoResult(winningLotto, bonusNumber);
        lottoOutputView.printLottoResult(lottoResult);
    }

    private LottoPurchasePrice requestLottoPurchasePrice() {
        lottoOutputView.printLottoPurchasePrice();
        int lottoPurchasePrice = lottoInputView.readLottoPurchasePrice();
        return LottoPurchasePrice.ofPurchasePriceAndConfig(lottoPurchasePrice, lottoConfig);
    }

    private LottoBundle issueLottoBundle(LottoPurchasePrice lottoPurchasePrice) {
        LottoDispenser lottoDispenser = LottoDispenser.fromConfig(lottoConfig);
        return lottoDispenser.issueLottoBundle(lottoPurchasePrice);
    }

    private WinningLotto requestLottoWinningNumbers() {
        lottoOutputView.printLottoWinningNumbers();
        List<Integer> lottoWinningNumbers = lottoInputView.readLottoWinningNumbers();
        return WinningLotto.ofNumbersAndConfig(lottoWinningNumbers, lottoConfig);
    }

    private BonusNumber requestLottoBonusNumber(WinningLotto winningLotto) {
        lottoOutputView.printLottoBonusNumber();
        int lottoBonusNumber = lottoInputView.readLottoBonusNumber();
        return BonusNumber.ofNumberAndWinningLottoAndConfig(lottoBonusNumber, winningLotto, lottoConfig);
    }

}
