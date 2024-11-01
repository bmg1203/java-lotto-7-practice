package lotto.controller;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public LottoController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public void process() {
        String lottoPurchaseAmount = inputView.inputLottoPurchaseAmount();
        inputValidator.validatePurchaseAmount(lottoPurchaseAmount);
        LottoSeller lottoSeller = new LottoSeller(new LottoMachine());
        Customer customer = new Customer(Money.from(lottoPurchaseAmount));
        lottoSeller.sellUntilNoMoneyTo(customer);
        List<Lotto> lottos = customer.getLottos();
        outputView.printPurchaseLottos(lottos);

        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumbers = Stream.of(winningNumber.split(","))
                .map(Integer::valueOf)
                .toList();
        outputView.printEmptyLine();
        String inputBonusNumber = inputView.inputBonusNumber();
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResult lottoResult = customer.calculateLottoResult(winningLotto);
        outputView.printLottoResults(lottoResult);
    }
}
