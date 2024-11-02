package lotto.controller;

import lotto.exception.ValidationValues;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void startLotto() {
        String inputPurchaseAmount = InputView.getLottoPurchaseAmount();
        int purchaseAmount = ValidationValues.purchaseAmount(inputPurchaseAmount);
        int count = purchaseAmount / 1000;
        lottoService.generateLotto(count);
    }

}
