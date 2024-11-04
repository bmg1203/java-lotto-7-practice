package lotto.utils.inputValidator.comparison;

import static lotto.exception.ErrorMessages.BONUS_NUMBER_DUPLICATION;

import java.util.List;
import lotto.utils.inputValidator.InputValidator;

public class BonusNumberValidator implements ComparisonValidator {
    private final InputValidator<String> positiveIntValidator;
    private final InputValidator<Integer> lottoNumberValidator;

    public BonusNumberValidator(
            InputValidator<String> positiveIntValidator
            , InputValidator<Integer> lottoNumberValidator) {

        this.positiveIntValidator = positiveIntValidator;
        this.lottoNumberValidator = lottoNumberValidator;
    }

    private static void validateNoDuplication(
            int bonusNumber
            , List<Integer> winningNumbers) {

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format(BONUS_NUMBER_DUPLICATION.getMessage(), bonusNumber));
        }

    }

    @Override
    public void validateWithComparison(String rawBonusNumber, List<Integer> winningNumbers) {
        validate(rawBonusNumber);
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        validateNoDuplication(bonusNumber, winningNumbers);
    }

    @Override
    public void validate(String rawBonusNumber) {

        positiveIntValidator.validate(rawBonusNumber);

        int bonusNumber = Integer.parseInt(rawBonusNumber);

        lottoNumberValidator.validate(bonusNumber);
    }
}
