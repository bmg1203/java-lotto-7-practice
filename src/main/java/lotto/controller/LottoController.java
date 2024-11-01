package lotto.controller;

import lotto.constants.Ranking;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.utils.LottoNumbersGenerator;
import lotto.utils.Retry;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class LottoController {

    public void run(){
        LottoStore lottoStore = new LottoStore(new LottoNumbersGenerator());
        LottoTicket lottoTicket =  Retry.retryOnException(() -> buyLotto(lottoStore));
        WinningLotto winningLotto = Retry.retryOnException(() -> createWinningLotto());
        checkLottoResult(lottoTicket, winningLotto);
    }

    private LottoTicket buyLotto(LottoStore lottoStore){
        int amount =  InputView.inputPurchaseAmount();
        LottoTicket lottoTicket = lottoStore.buyLottoTicket(amount);
        OutputView.printLottoTicketInformation(lottoTicket.getAllLottoNumbers(), lottoTicket.getLottoCount());
        return lottoTicket;
    }

    private WinningLotto createWinningLotto(){
        List<Integer> winNumbers = Retry.retryOnException(() -> InputView.inputWinNumbers());
        Integer bonusNumber = Retry.retryOnException(() -> InputView.inputBonusNumber());
        return WinningLotto.of(winNumbers, bonusNumber);
    }

    private void checkLottoResult(LottoTicket lottoTicket, WinningLotto winningLotto){
        EnumMap<Ranking, Integer> lottoResult = lottoTicket.checkRanking(winningLotto);
        double profitRate = lottoTicket.calculateProfitRate(winningLotto);
        OutputView.printWinStatistics(profitRate, lottoResult);
    }
}
