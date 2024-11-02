package lotto.service;

import lotto.controller.DataController;
import lotto.model.Lotto;
import lotto.model.LottoWinningNumber;
import lotto.service.lottoImpl.ApplicationServiceImpl;
import lotto.util.Output;

import java.util.List;

public class ApplicationService implements ApplicationServiceImpl {
    private final DataController dataController = new DataController(new DataService());

    @Override
    public List<Lotto> inputLottos(int tickets) {
        List<Lotto> lottos = dataController.createLottos(tickets);
        Output.printLottos(lottos);

        return lottos;
    }

    @Override
    public LottoWinningNumber inputWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        return dataController.createWinningNumber(winningNumbers, bonusNumber);
    }
}
