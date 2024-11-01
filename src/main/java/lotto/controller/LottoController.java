package lotto.controller;


import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.LottoBundle;
import lotto.domain.LottoPurchasePrice;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.generator.LottoGenerator;
import lotto.util.LottoParser;
import lotto.validator.LottoBonusNumberValidator;
import lotto.validator.LottoWinningNumbersValidator;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoGenerator lottoGenerator;
    private final LottoWinningNumbersValidator lottoWinningNumbersValidator;
    private final LottoBonusNumberValidator lottoBonusNumberValidator;

    public LottoController(
            LottoView lottoView,
            LottoGenerator lottoGenerator,
            LottoWinningNumbersValidator lottoWinningNumbersValidator,
            LottoBonusNumberValidator lottoBonusNumberValidator
    ) {
        this.lottoView = lottoView;
        this.lottoGenerator = lottoGenerator;
        this.lottoWinningNumbersValidator = lottoWinningNumbersValidator;
        this.lottoBonusNumberValidator = lottoBonusNumberValidator;
    }

    public void run() {
        LottoPurchasePrice lottoPurchasePrice = retry(this::requestLottoPurchasePrice);
        LottoBundle lottoBundle = lottoGenerator.generateLottoBundle(lottoPurchasePrice);
        lottoView.printLottoBundle(lottoBundle);
        WinningLotto winningLotto = retry(this::requestLottoWinningNumbers);
        BonusNumber bonusNumber = retry(this::requestLottoBonusNumber, winningLotto);
        LottoResult lottoResult = lottoBundle.makeLottoResult(winningLotto, bonusNumber);
        lottoView.printLottoResult(lottoResult);
    }

    private LottoPurchasePrice requestLottoPurchasePrice() {
        int lottoPurchasePrice = lottoView.requestLottoPurchasePrice();
        return LottoPurchasePrice.from(lottoPurchasePrice);
    }

    private WinningLotto requestLottoWinningNumbers() {
        String lottoWinningNumbers = lottoView.requestLottoWinningNumbers();
        lottoWinningNumbersValidator.validateLottoWinningNumbers(lottoWinningNumbers);
        List<Integer> winningNumbers = LottoParser.parseNumbers(lottoWinningNumbers);
        return WinningLotto.of(winningNumbers);
    }

    private BonusNumber requestLottoBonusNumber(WinningLotto winningLotto) {
        String lottoBonusNumber = lottoView.requestLottoBonusNumber();
        lottoBonusNumberValidator.validateBonusNumber(lottoBonusNumber, winningLotto);
        int bonusNumber = LottoParser.parseInt(lottoBonusNumber);
        return BonusNumber.of(bonusNumber);
    }

    private <T> T retry(Supplier<T> logic) {
        boolean retryFlag = true;
        T result = null;
        while (retryFlag) {
            try {
                result = logic.get();
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    private <T, R> R retry(Function<T, R> logic, T data) {
        boolean retryFlag = true;
        R result = null;
        while (retryFlag) {
            try {
                result = logic.apply(data);
                retryFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
