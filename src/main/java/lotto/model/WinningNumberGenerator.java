package lotto.model;

import lotto.util.common.ErrorMessage;
import lotto.util.common.Regex;

import java.util.Arrays;
import java.util.List;

public class WinningNumberGenerator {
    public Lotto createWinningNumbers(String rawWinningNumbers) {
        validate(rawWinningNumbers);
        List<String> winningNumbers = splitWinningNumbers(rawWinningNumbers);
        List<Integer> numbers = convertWinningNumbers(winningNumbers);
        return Lotto.createWinningLotto(numbers);
    }

    private List<String> splitWinningNumbers(String rawWinningNumbers) {
        return Arrays.asList(rawWinningNumbers.split(Regex.DELIMITER_COMMA.getRegex()));
    }

    private List<Integer> convertWinningNumbers(List<String> rawWinningNumbers) {
        try {
            return rawWinningNumbers.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getError());
        }
    }

    private void validate(String rawWinningNumbers) {
        validateFormat(rawWinningNumbers);
    }

    private void validateFormat(String rawWinningNumbers) {
        if (!rawWinningNumbers.matches(Regex.ONLY_DIGIT_WITH_COMMA.getRegex())) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getError());
        }
    }
}
