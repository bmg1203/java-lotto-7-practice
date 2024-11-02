package lotto.handler;

import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.PrizeTier;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class ResultHandler {
    private final LottoService lottoService;
    private final OutputView outputView;

    public ResultHandler(LottoService lottoService, OutputView outputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
    }

    public void calculateAndDisplayResults() {
        Map<PrizeTier, Long> prizeCounts = getPrizeCounts();
        Map<PrizeTier, Integer> integerPrizeCounts = convertToIntegerPrizeCounts(prizeCounts);
        displayPrizeResults(integerPrizeCounts);
    }

    private Map<PrizeTier, Long> getPrizeCounts() {
        return retrieveResultsFromService();
    }

    private Map<PrizeTier, Long> retrieveResultsFromService() {
        return lottoService.calculateResults();
    }

    private Map<PrizeTier, Integer> convertToIntegerPrizeCounts(Map<PrizeTier, Long> prizeCounts) {
        return prizeCounts.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue()
                ));
    }

    private void displayPrizeResults(Map<PrizeTier, Integer> integerPrizeCounts) {
        outputView.printWinningResults(integerPrizeCounts);
    }

    public void displayProfitRate(int purchaseAmount) {
        double profitRate = getProfitRate(purchaseAmount);
        outputView.printProfitRate(profitRate);
    }

    private double getProfitRate(int purchaseAmount) {
        return lottoService.calculateProfitRate(purchaseAmount);
    }
}
