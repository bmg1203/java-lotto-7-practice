package lotto;

import java.util.List;
import lotto.io.InputMessage;
import lotto.io.InputReader;
import lotto.io.OutputPrinter;

public class LottoApplication {

    private final InputReader inputReader;
    private final OutputPrinter outputPrinter;
    private final LottoGenerator lottoGenerator;

    public LottoApplication() {
        this.inputReader = new InputReader();
        this.outputPrinter = new OutputPrinter();
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        InputMessage.purchaseAmount();
        long purchaseAmount = inputReader.readPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.purchase(purchaseAmount);
        outputPrinter.printLottoCreated(lottos);
    }

}
