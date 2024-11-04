package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.util.InputFormatter;

public class LottoService {

    private static final double ONE_HUNDRED_DECIMAL = 100.0;

    private final InputFormatter inputFormatter;
    private PurchasedLotto purchasedLotto;
    private Lotto winningLottoNumbers;
    private WinningLotto winningLotto;

    public LottoService() {
        this.inputFormatter = new InputFormatter();
    }

    public void purchaseLotto(String moneyInput) {
        this.purchasedLotto = new PurchasedLotto(inputFormatter.formatMoneyInput(moneyInput));
    }

    public String purchasedLottoNumbersMessage() {
        return this.purchasedLotto.toString();
    }

    public void setWinningLotto(String winningNumbersInput) {
        List<Integer> winningNumbers = inputFormatter.formatWinningNumbersInput(winningNumbersInput);
        this.winningLottoNumbers = new Lotto(winningNumbers);
    }

    public void setBonusNumber(String bonusNumberInput) {
        int bonusNumber = inputFormatter.formatBonusNumberInput(bonusNumberInput);
        this.winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    public void checkLottoResult() {
        for (Lotto lotto : purchasedLotto.getPurchasedLotto()) {
            int matchNumbers = winningLotto.findMatchNumbers(lotto);
            LottoRank.checkLottoPrize(matchNumbers, winningLotto.hasBonusNumber(lotto));
        }
    }

    public List<String> getResultsOfLotto() {
        return Arrays.stream(LottoRank.values())
                .map(LottoRank::toString)
                .toList();
    }

    public double getRateOfReturn() {
        return LottoRank.getTotalPrize() * ONE_HUNDRED_DECIMAL / purchasedLotto.getMoney();
    }
}
