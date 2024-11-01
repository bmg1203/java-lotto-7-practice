package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController(LottoService lottoService, LottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public void run() {
        int money = 3000;
        List<Lotto> purchasedLottos = lottoService.purchaseBy(money);

        Lotto winningLotto = Lotto.of(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);

        Map<LottoRank, Integer> ranks = lottoService.evaluateLottos(winningLotto, bonusNumber, purchasedLottos);
        lottoView.showWinningResult(ranks);
    }

}
