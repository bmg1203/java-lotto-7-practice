package lotto.handler;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGenerateController {

    private final RandomValueGenerator generator;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGenerateController(RandomValueGenerator generator, InputView inputView, OutputView outputView) {
        this.generator = generator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Lotto> purchaseAll() {
        int amount = getAmount();

        List<Lotto> lottoList = new ArrayList<>();
        for (int round = 0; round < amount; round++) {
            lottoList.add(purchaseLotto());
        }

        return lottoList;
    }

    private int getAmount() {
        int price = inputView.getPrice();
        return price / 1000;
    }

    private Lotto purchaseLotto() {
        return new Lotto(generator.generate());
    }
}
