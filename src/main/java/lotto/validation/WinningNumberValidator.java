package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionMessage;

public class WinningNumberValidator {

    public void validateNumber(String winningLottoNumber) {
        if (winningLottoNumber == null || winningLottoNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_BLANK_INPUT.getMessage());
        }
    }

    public void validateNumbers(List<Integer> lottoNumbers) {
        checkBlankInput(lottoNumbers);
        checkSize(lottoNumbers);
        checkRange(lottoNumbers);
        checkDuplicates(lottoNumbers);
    }

    private void checkBlankInput(List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_BLANK_INPUT.getMessage());
        }
    }

    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_SIZE_INSUFFICIENT.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }
}
