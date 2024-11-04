package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoService;
import lotto.service.StatisticsService;

public class Application {
    public static void main(String[] args) {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        LottoService lottoService = new LottoService(generator);
        StatisticsService statisticsService = new StatisticsService();
        LottoController controller = new LottoController(lottoService, statisticsService);

        controller.run();
    }
}
