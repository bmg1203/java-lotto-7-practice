package lotto.controller;

import lotto.dto.LottoRequestDto;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.utils.LottoConverter;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumbersValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String purchaseAmount = inputView.getPurchaseAmount();
        PurchaseAmountValidator.validate(purchaseAmount);
        int userAmount = Integer.parseInt(purchaseAmount) / 1000;
        List<Lotto> userLottos = new ArrayList<>();
        for (int i = 0; i < userAmount; i++) {
            userLottos.add(LottoService.createLotto());
        }
        OutputView.printUserLottos(userLottos, userAmount);

        String lottoNumbers = inputView.getLottoNumbers();
        String bonusNumber = inputView.getBonusNumber();
        LottoNumbersValidator.validate(lottoNumbers);
        BonusNumberValidator.validate(bonusNumber, lottoNumbers.split(","));

        LottoRequestDto lottoRequestDto = new LottoRequestDto(purchaseAmount, lottoNumbers, bonusNumber);
        LottoService lottoService = new LottoService(
                LottoConverter.parseLottoNumbers(lottoRequestDto.getLottoNumbers()),
                LottoConverter.parseBonusNumber(lottoRequestDto.getBonusNumber()));

        Map<String, Integer> userLottoStatistics = lottoService.calculateUserLottoStatistics(userLottos);
        OutputView.printUserLottoStatistics(userLottoStatistics);
    }
}
