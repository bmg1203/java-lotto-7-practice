package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            // 구입 금액을 입력 받고 로또 구매
            int amount = InputView.getPurcahseAmount();
            List<Lotto> userLottos = lottoService.purchase(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
