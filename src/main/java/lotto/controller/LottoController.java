package lotto.controller;

import java.util.List;
import lotto.repository.Lotto;
import lotto.service.LottoPublishService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    LottoPublishService lottoPublishService = LottoPublishService.getInstance();

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startLottoGame() {
        this.buyLotto();
        this.lottoPublish();
    }

    private void buyLotto() {
        this.requestInputPrice();
    }

    private void requestInputPrice() {
        try {
            lottoPublishService.lottoPublish(inputView.requestInputPrice());
        } catch (IllegalArgumentException e) {
            inputView.printMessage(e.getMessage());
            this.requestInputPrice();
        }
    }

    private void lottoPublish() {
        List<Lotto> lottos = lottoPublishService.getPublishedLottoNumbers();
        outputView.printPublishCount(lottos.size());
        outputView.printPublishedLottoNumbers(lottoPublishService.getPublishedLottoNumbers());
    }
}
