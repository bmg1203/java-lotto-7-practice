package lotto.service;

import lotto.constants.LottoConstants;
import lotto.domain.*;
import lotto.generator.RandomLottoNumberGenerator;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchaseAmountValidator;
import lotto.validation.WinningNumberValidator;

import java.util.Arrays;
import java.util.List;

public class LottoServiceImpl implements LottoService {
    @Override
    public LottoTicket generateLottoTicket(String purchaseAmountInput) {
        int lottoCount = calculateLottoCount(purchaseAmountInput);
        return new LottoTicket(new RandomLottoNumberGenerator(), lottoCount);
    }

    @Override
    public WinningLotto createWinningLotto(String winningNumbersInput, String bonusNumberInput) {
        List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);

        BonusNumberValidator.validateBonusNumberInput(bonusNumberInput);
        int bonusNumber = parseBonusNumber(bonusNumberInput);
        BonusNumberValidator.validateBonusNumber(winningNumbers, bonusNumber);

        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    @Override
    public LottoResult createLottoResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottoTicket.getLottos().forEach(lotto -> {
           Rank rank = calculateRank(lotto, winningLotto);
           lottoResult.addResult(rank);
        });

        return lottoResult;
    }

    private int calculateLottoCount(String purchaseAmountInput) {
        PurchaseAmountValidator.validatePurchaseAmountInput(purchaseAmountInput);
        int purchaseAmount = parsePurchaseAmount(purchaseAmountInput);
        PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);

        return convertToLottoCount(purchaseAmount);
    }

    private int parsePurchaseAmount(String purchaseAmountInput) {
        return Integer.parseInt(purchaseAmountInput.trim());
    }

    private int convertToLottoCount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE_BASE_UNIT;
    }

    private List<Integer> parseWinningNumbers(String winningNumbersInput) {
        WinningNumberValidator.validateWinningNumbersInput(winningNumbersInput);

        return Arrays.stream(winningNumbersInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
    private int parseBonusNumber(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput.trim());
    }

    private Rank calculateRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getWinningNumbers().getNumbers()::contains)
                .count();
        boolean isBonusMatched = lotto.getNumbers().contains(winningLotto.getBonusNumber());

        return Rank.valueOf(matchCount, isBonusMatched);
    }
}
