package lotto.controller;

import lotto.domain.JackpotNumbers;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.util.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Controller {

    public void run() {
        int totalAmount = getTotalAmount();
        int lottoCount = totalAmount / 1000;
        List<Lotto> purchasedLottos = LottoListGenerator.generateLottos(lottoCount);

        OutputView.printPurchasedLottos(lottoCount, purchasedLottos);
        OutputView.lineBreaking();

        JackpotNumbers jackpotNumbers = getJackpotNumbers();
        Map<Ranking, Integer> rankingMap = RankingEvaluator.evaluateAll(purchasedLottos, jackpotNumbers);
        OutputView.printWinningStatistics(rankingMap);

        double earningRate = EarningRateCalculator.calculate(totalAmount, rankingMap);
        OutputView.printEarningRate(earningRate);
    }

    private Integer getTotalAmount() {
        return retryOnError(() -> {
            String inputTotalAmount = InputView.requestAmountToPurchase();
            int purchaseAmount = StringParser.toInt(inputTotalAmount);
            Validator.validateTotalAmount(purchaseAmount);
            return purchaseAmount;
        });
    }

    private JackpotNumbers getJackpotNumbers() {
        Lotto jackpotNumber = retryOnError(() -> {
            String inputJackpotNumbers = InputView.requestJackpotNumbers();
            List<Integer> jackpotList = StringParser.toIntList(inputJackpotNumbers);
            return new Lotto(jackpotList);
        });

        int bonusNumber = retryOnError(() -> {
            String inputBonusNumber = InputView.requestBonusNumber();
            int number = StringParser.toInt(inputBonusNumber);
            Validator.validateNumber(number, jackpotNumber);
            return number;
        });

        return new JackpotNumbers(jackpotNumber, bonusNumber);
    }

    private <T> T retryOnError(Supplier<T> inputAction) {
        while (true) {
            try {
                return inputAction.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}