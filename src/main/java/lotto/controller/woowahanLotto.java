package lotto.controller;

import static lotto.utils.Converter.StringToPrice;
import static lotto.utils.Converter.priceToLottoCount;
import static lotto.view.OutputView.printErrorMessage;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLottos;
import lotto.global.LottoRank;
import lotto.utils.Converter;
import lotto.utils.Generator;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class woowahanLotto implements LottoController {
    @Override
    public void run() {
        String input = getLottoCount();
        int lottoCount = priceToLottoCount(input);
        int price = StringToPrice(input);

        Lottos lottos = getLottos(lottoCount);
        OutputView.printLottos(lottos);

        List<Integer> winningNumbers = getWinningNum();
        int bonusNumber = getBonusNumber();

        WinningLottos winningLottos = getWinningLottos(lottos.getWinningLottos(winningNumbers,bonusNumber),price);
        OutputView.printResult(winningLottos);

    }

    private String getLottoCount() {
        try {
            String input = InputView.getPrice();
            Validator.priceValidator(input);
            return input;
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return getLottoCount();
        }
    }

    private Lottos getLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Generator.lottoNumberGenerate()));
        }
        return new Lottos(lottos);
    }

    private List<Integer> getWinningNum() {
        try {
            String input = InputView.getWinningNumber();
            Validator.winningNumValidator(input);
            return Converter.StringToLottoNumbers(input);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return getWinningNum();
        }
    }

    private int getBonusNumber() {
        try {
            String input = InputView.getBonusNumber();
            Validator.lottoNumValidator(input);
            return Converter.StringToBonusNumber(input);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return getBonusNumber();
        }
    }

    private WinningLottos getWinningLottos(List<LottoRank> winningLottos, int price) {
        return new WinningLottos(winningLottos,price);
    }
}
