package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.parser.StringParser;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

public class LottoController {

    private final InputReader reader;
    private final OutputWriter writer;

    public LottoController(final InputReader reader, final OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void buy() {
        final LottoPurchase lottoPurchase = purchaseLotto();
        final Lottos lottos = createLotto(lottoPurchase);
        writer.purchasedLottos(lottoPurchase, lottos);
        final WinningNumbers winningNumbers = winningNumbers();
        writer.winningNumbers(winningNumbers);
    }

    private LottoPurchase purchaseLotto() {
        while (true) {
            try {
                return reader.purchase();
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    private Lottos createLotto(final LottoPurchase purchase) {
        return Lottos.createAuto(purchase.getLottoCount());
    }

    private WinningNumbers winningNumbers() {
        while (true) {
            try {
                return reader.winningNumbers();
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }
}
