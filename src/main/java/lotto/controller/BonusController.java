package lotto.controller;

import java.util.List;
import lotto.Factory.BonusGeneratorFactory;
import lotto.domain.Lotto;
import lotto.service.BonusGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PrintMessage;

public class BonusController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BonusGenerator bonusGenerator;

    public BonusController(InputView inputView, OutputView outputView, Lotto winnings) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bonusGenerator = inputLottoBonus(winnings);
    }

    private BonusGenerator inputLottoBonus(Lotto winning) {
        outputView.printlnMessage(PrintMessage.LINE_SPACE);
        outputView.printlnMessage(PrintMessage.INPUT_LOTTO_BONUS_NUMBER);

        String lottoBonus = inputView.inputUser();
        return BonusGeneratorFactory.create(winning, lottoBonus);
    }

    public BonusGenerator getBonusGenerator() {
        return bonusGenerator;
    }
}
