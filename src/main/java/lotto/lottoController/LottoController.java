package lotto.lottoController;

import java.util.List;
import lotto.lottoModel.HitLottoDAO;
import lotto.lottoModel.HitLottoDTO;
import lotto.lottoModel.LottoDAO;
import lotto.lottoModel.LottoDTO;
import lotto.lottoModel.Lotto;
import lotto.lottoModel.StatisticsLottoDAO;
import lotto.lottoModel.StatisticsLottoDTO;
import lotto.lottoView.InputView;
import lotto.lottoView.OutputView;
import lotto.lottoService.LottoMainService;

import lotto.Utility.LottoNumberGenerator;

public class LottoController {
    private LottoDAO lottoDAO;
    private LottoDTO lottoDTO;
    private final InputView inputView;
    private final OutputView outputView;
    private HitLottoDAO hitLottoDAO;
    private HitLottoDTO hitLottoDTO;
    private StatisticsLottoDAO statisticsDAO;
    private StatisticsLottoDTO statisticsDTO;
    private final LottoMainService lottoMainService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();


        this.lottoMainService = new LottoMainService();
    }

    public void run() {
        String cost = inputView.PrintStartMsg();
        //여기에 유효성 검증

        long calcCost = Long.parseLong(cost);
        outputView.howManyBuy(calcCost/1000);
        lottoMainService.buyLotto(calcCost);

        List<LottoDTO> allLottosAsDTO = lottoMainService.getAllLottosAsDTO();
        for (LottoDTO dto : allLottosAsDTO) {
            outputView.printLottoNumbers(dto);
        }


        String hitLottoInput = inputView.PrintLottoInputMsg();
        String bonusNumberInput = inputView.PrintBonusLottoInputMsg();
        //여기에 유효성 검증

        lottoMainService.saveHitLotto(hitLottoInput, bonusNumberInput);

        HitLottoDTO dto = hitLottoDAO.getAsDTO(); //?

        lottoMainService.retainLotto(allLottosAsDTO, dto.getAllHitNumbers());

        StatisticsLottoDTO stats = statisticsDAO.getStatisticsAsDTO();
        outputView.statisticStart(stats);

        long sumPrize = lottoMainService.sumPrize(stats);
        double profit = sumPrize / calcCost;
        outputView.profitMessage(profit);


    }

}
