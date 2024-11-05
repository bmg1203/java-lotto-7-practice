package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningLottoWithBonus;
import lotto.dto.PrizeResponse;
import lotto.dto.PurchasedLottosResponse;
import lotto.parser.LottoNumbersInputParser;
import lotto.view.ConsoleView;

import java.util.List;

public class LottoController {
    private final ConsoleView consoleView;

    public LottoController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(purchaseAmount);
        printPurchasedLottos(purchasedLottos);

        Lotto winningLotto = readWinningLottoNumbers();
        LottoNumber bonusNumber = readBonusNumber();
        WinningLottoWithBonus winningLottoWithBonus = new WinningLottoWithBonus(winningLotto, bonusNumber);

        List<PrizeResponse> winningResult = winningLottoWithBonus.findWinningResult(purchasedLottos);
        consoleView.printWinningResult(winningResult);

        double profitRate = calculateProfitRate(purchaseAmount, winningResult);
        consoleView.printProfitRate(profitRate);
    }

    private PurchaseAmount readPurchaseAmount() {
        int purchaseAmountInput = consoleView.readPurchaseAmountInput();

        return new PurchaseAmount(purchaseAmountInput);
    }

    private List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculatePurchasableLottoCount();
        consoleView.printPurchasableLottoCount(lottoCount);
        LottoGenerator lottoGenerator = new LottoGenerator();

        return lottoGenerator.generateLottos(lottoCount);
    }

    private void printPurchasedLottos(List<Lotto> purchasedLottos) {
        consoleView.printPurchasedLottos(PurchasedLottosResponse.from(purchasedLottos));
    }

    private Lotto readWinningLottoNumbers() {
        String winningLottoNumbersInput = consoleView.readWinningLottoNumbersInput();
        LottoNumbersInputParser lottoNumbersInputParser = new LottoNumbersInputParser();
        List<Integer> lottoNumbers = lottoNumbersInputParser.parse(winningLottoNumbersInput);

        return new Lotto(lottoNumbers);
    }

    private LottoNumber readBonusNumber() {
        int bonusNumberInput = consoleView.readBonusNumberInput();

        return new LottoNumber(bonusNumberInput);
    }

    private double calculateProfitRate(PurchaseAmount purchaseAmount, List<PrizeResponse> winningResult) {
        int totalProfit = winningResult.stream()
                .mapToInt(PrizeResponse::getProfit)
                .sum();

        return purchaseAmount.calculateProfitRate(totalProfit);
    }
}
