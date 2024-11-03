package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoResultAnalysisService;
import lotto.service.LottoSalesService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoSalesService salesService;
    private LottoResultAnalysisService resultAnalysisService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.salesService = new LottoSalesService();
        this.resultAnalysisService = null;
    }

    public void run() {
        outputView.printPaymentRequestMessage();
        int payment = inputView.readPayment();
        int quantity = salesService.getAvailableLottoQuantity(payment);
        List<Lotto> lottos = salesService.createLottos(quantity);
        outputView.printLottoDetails(lottos);

        outputView.printWinningNumbersRequestMessage();
        String numbers = inputView.readWinningNumbers();

        outputView.printBonusNumberRequestMessage();
        int bonusNumber = 7; // TODO: InputView

        List<Integer> winningNumbers = createWinningNumbers(numbers);
        // TODO: 개선 요망
        setLottoResultAnalysisService(winningNumbers, bonusNumber);

        List<Rank> winningResults = resultAnalysisService.generateWinningResults(lottos);
        List<Integer> winningStatistics = resultAnalysisService.getWinningStatistics(winningResults);
        String lottoProfitRate = resultAnalysisService.getLottoProfitRate(winningResults, payment);

        outputView.printWinningResults(winningStatistics, lottoProfitRate);
    }

    private void setLottoResultAnalysisService(List<Integer> winningLottoNumbers, int bonusNumber) {
        if(resultAnalysisService == null) {
            resultAnalysisService = new LottoResultAnalysisService(winningLottoNumbers, bonusNumber);
        }
    }

    private List<Integer> createWinningNumbers(String numbers) {
        String[] splitNumbers = numbers.split(",");
        try {
            return Arrays.stream(splitNumbers)
                .mapToInt(Integer::parseInt).boxed().toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 정수여야 합니다.");
        }
    }
}
