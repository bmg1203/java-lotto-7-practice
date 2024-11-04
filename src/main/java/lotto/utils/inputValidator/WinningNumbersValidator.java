package lotto.utils.inputValidator;

import static lotto.constants.LottoTicket.NUMBERS_PER_LOTTO;
import static lotto.exception.ErrorMessages.EMPTY_INPUT;
import static lotto.exception.ErrorMessages.NUMBER_COUNT_MISMATCH;
import static lotto.utils.constants.Constants.DELIMITER;

public class WinningNumbersValidator implements InputValidator<String> {

    private final InputValidator<String> positiveIntValidator;
    private final InputValidator<Integer> lottoNumberValidator;

    public WinningNumbersValidator(
            InputValidator<String> positiveIntValidator,
            InputValidator<Integer> lottoNumberValidator) {

        this.positiveIntValidator = positiveIntValidator;
        this.lottoNumberValidator = lottoNumberValidator;
    }

    @Override
    public void validate(String rawWinningNumbers) {
        validateNotEmpty(rawWinningNumbers);
        String[] rawWinningNumberList = rawWinningNumbers.split(DELIMITER.getDelimiter());

        validateLottoFormat(rawWinningNumberList);
    }

    private void validateNotEmpty(String rawWinningNumbers) {
        if (rawWinningNumbers.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private void validateLottoFormat(String[] rawWinningNumberList) {
        for (String rawWinningNumber : rawWinningNumberList) {
            validateEachRawWinningNumber(rawWinningNumber);
        }

        if (rawWinningNumberList.length != NUMBERS_PER_LOTTO.getValue()) {
            throw new IllegalArgumentException(
                    String.format(NUMBER_COUNT_MISMATCH.getMessage(), NUMBERS_PER_LOTTO.getValue()));
        }
    }

    private void validateEachRawWinningNumber(String rawWinningNumber) {
        positiveIntValidator.validate(rawWinningNumber);

        int lottoNumber = Integer.parseInt(rawWinningNumber);
        lottoNumberValidator.validate(lottoNumber);
    }
}
