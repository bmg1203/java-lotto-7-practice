package lotto.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.parser.InputParser;
import lotto.utils.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        int quantity = setQuantity();

        List<Lotto> lottoList = setLottoNumbers(quantity);
        printLottoList(quantity, lottoList);

        WinningLotto winningLotto = setWinningLotto();

        int totalPrize = printEachPlaceResult(lottoList, winningLotto);
        printProfitRate(totalPrize, quantity);
    }

    /**
     * 구매 갯수 set
     */
    private int setQuantity() {
        while(true) {
            try {
                OutputView.printPurchaseAmountMessage();
                String input = InputView.getPurchaseAmount();

                return InputParser.parsePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * 구매한 List<Lotto> set
     */
    private List<Lotto> setLottoNumbers(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(RandomNumberGenerator.generateLottoNumbers()))
                .toList();
    }

    /**
     * 구매한 로또 갯수 및 List<Lotto> 출력
     */
    private void printLottoList(int quantity, List<Lotto> lottoList) {
        OutputView.printLottoQuantity(quantity);

        lottoList.forEach(OutputView::printLottoList);
    }

    /**
     * WinningLotto set
     */
    private WinningLotto setWinningLotto() {
        while(true) {
            try {
                OutputView.printWinningLottoNumbersMessage();
                String winningNumbers = InputView.getWinningLottoNumbers();

                OutputView.printBonusNumberMessage();
                int bonusNumber = InputView.getBonusNumber();

                return InputParser.parseWinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * 당첨번호 숫자 일치 갯수 별 로또 갯수 출력
     */
    private int printEachPlaceResult(List<Lotto> lottoList, WinningLotto winningLotto) {
        OutputView.printResultMessage();

        int totalPrize = 0;
        EnumMap<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }

        for(Lotto lotto : lottoList) {
            LottoRank rank = lotto.determineRank(winningLotto);
            totalPrize += rank.getPrize();
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        OutputView.printResult(rankCounts);

        return totalPrize;
    }

    /**
     * 수익률 출력
     */
    private void printProfitRate(int totalPrize, int quantity) {
        double profitRate = (double) totalPrize / (quantity * 1000) * 100;

        BigDecimal roundedProfitRate = BigDecimal.valueOf(profitRate)
                .setScale(2, RoundingMode.HALF_UP);

        OutputView.printProfitRate(roundedProfitRate.doubleValue());
    }

}
