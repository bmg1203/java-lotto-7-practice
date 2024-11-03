package lotto.dto;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

public record BonusNumberInput(String input) {

    public BonusNumberInput {
        validate(input);
    }

    private void validate(String input) {
        validateLottoNumbersNotNull(input);
        validateLottoNumbersNotEmpty(input);
    }

    private void validateLottoNumbersNotNull(String input) {
        if (input == null) {
            throw CustomIllegalArgumentException.from(NULL_INPUT);
        }
    }

    private void validateLottoNumbersNotEmpty(String input) {
        if (input.isEmpty()) {
            throw CustomIllegalArgumentException.from(EMPTY_INPUT);
        }
    }
}
