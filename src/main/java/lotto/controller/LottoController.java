package lotto.controller;

import java.util.List;
import lotto.converter.StringToIntConverter;
import lotto.service.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.util.ErrorMessage;
import lotto.util.NumberGenerate;
import lotto.domain.BonusBall;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final StringToIntConverter converter;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerate lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = new LottoMachine(lottoGenerator);
        this.converter = new StringToIntConverter();
    }

    public void run() {
        PurchasedLottos purchasedLotto = inputMoney();

        outputView.showHowManyLotto(purchasedLotto);
        outputView.showAllLottoNums(purchasedLotto);

        WinningLotto winningLotto = createWinningLotto();

        LottoResult lottoResult = lottoMachine.calculateLottoWins(purchasedLotto, winningLotto);

        outputView.showWinStatus(lottoResult);
        outputView.showProfit(lottoResult, lottoMachine.inMoney());
    }

    private WinningLotto createWinningLotto() {
        Lotto lotto = inputLottoNumbers();
        System.out.printf(System.lineSeparator());
        while (true) {
            try {
                BonusBall bonusBall = inputBonusNumber();
                return new WinningLotto(lotto, bonusBall);
            } catch (IllegalArgumentException e) {
                ErrorMessage.showErrorMsg(e.getMessage());
            }
        }
    }

    private BonusBall inputBonusNumber() {
        while (true) {
            try {
                String rawNumber = inputView.lottoBonusNumInput();
                int bonusNumber = converter.convertStringNumberToInteger(rawNumber);
                return new BonusBall(bonusNumber);
            } catch (RuntimeException e) {
                ErrorMessage.showErrorMsg(e.getMessage());
            }
        }
    }

    private Lotto inputLottoNumbers() {
        while (true) {
            try {
                String rawNumbers = inputView.lottoNumsInput();
                List<Integer> numbers = converter.convertStringNumbersToIntegers(rawNumbers);
                return new Lotto(numbers);
            } catch (RuntimeException e) {
                ErrorMessage.showErrorMsg(e.getMessage());
            }
        }
    }

    private PurchasedLottos inputMoney() {
        while (true) {
            try {
                String rawMoney = inputView.lottoMoneyInput();
                int money = converter.convertStringNumberToInteger(rawMoney);
                return lottoMachine.issueLotto(money);
            } catch (RuntimeException e) {
                ErrorMessage.showErrorMsg(e.getMessage());
            }
        }
    }
}
