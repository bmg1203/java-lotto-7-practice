package lotto.controller;

import static lotto.view.OutputMessage.*;

import java.util.List;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.Wallet;
import lotto.domain.vo.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount amount = inputPurchaseAmount();
        Wallet wallet = purchaseLotto(amount);
        printLottoNumbers(wallet);
    }

    private PurchaseAmount inputPurchaseAmount() {
        outputView.print(INPUT_PURCHASE_AMOUNT);
        try {
            return PurchaseAmount.from(inputView.readLine());
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private Wallet purchaseLotto(PurchaseAmount amount) {
        int count = amount.calculateRemainder();
        outputView.print(PURCHASE_RESULT, count);
        return Wallet.from(amount);
    }

    private void printLottoNumbers(Wallet wallet) {
        List<Lotto> lottos = wallet.lottos();
        for (Lotto lotto : lottos) {
            outputView.print(String.valueOf(lotto));
        }
    }
}
