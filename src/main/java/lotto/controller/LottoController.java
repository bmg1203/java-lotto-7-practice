package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.AnswerNumbers;
import lotto.domain.BonusNumber;
import lotto.domain.Payment;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.Lottos;
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
        Payment payment = retry(inputView::readPrice);
        Lottos lottos = purchase(payment);
        AnswerNumbers answerNumbers = create();
    }

    private Lottos purchase(Payment payment) {
        Lottos lottos = Lottos.from(payment.calculateCount());
        outputView.printLottos(lottos);
        return lottos;
    }

    private AnswerNumbers create() {
        WinningNumbers winningNumbers = retry(inputView::readWinningNumbers);
        BonusNumber bonusNumber = retry(() -> inputView.readBonusNumber(winningNumbers));
        return AnswerNumbers.from(winningNumbers, bonusNumber);
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }
}
