package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.util.InputParsingUtil;
import lotto.util.RetryUtil;
import lotto.validator.BonusNumValidator;
import lotto.validator.LottoValidator;
import lotto.validator.PurchasePriceValidator;
import lotto.view.InputView;

import java.util.List;

public class InputService {

    private final InputView inputView;

    public InputService(final InputView inputView) {
        this.inputView = inputView;
    }

    public PurchasePrice readPurchasePrice() {
        return RetryUtil.executeWithRetry(() -> {
            int purchasePrice = inputView.readPurchasePrice();
            PurchasePriceValidator.validatePurchasePrice(purchasePrice);
            return new PurchasePrice(purchasePrice);
        });
    }

    public WinningLotto readWinningLotto() {
        Lotto lotto = readWinningLottoNumbers();
        int bonusNum = readBonusNum(lotto);
        return new WinningLotto(lotto, bonusNum);
    }

    private Lotto readWinningLottoNumbers() {
        return RetryUtil.executeWithRetry(() -> {
            String input = inputView.readWinningNumbers();
            List<Integer> numbers = InputParsingUtil.parseWinningLottoNumbers(input);
            LottoValidator.validate(numbers);
            return new Lotto(numbers);
        });
    }

    private int readBonusNum(Lotto winningLotto) {
        return RetryUtil.executeWithRetry(() -> {
            int bonusNumber = inputView.readBonusNumber();
            new BonusNumValidator(winningLotto).validateBonusNum(bonusNumber);
            return bonusNumber;
        });
    }

}
