package lotto.domain;

import static lotto.constant.ErrorMessage.WINNING_NUMBERS_NOT_NATURAL_NUMBERS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WinningNumbers {

    private static final String DELIMITER = ",";

    private Lotto numbers;

    public WinningNumbers(String winningNumbersInput) {
        validate(winningNumbersInput);
        List<Integer> validIntegerNumbers = toIntegerList(winningNumbersInput);
        validIntegerNumbers.sort(Comparator.naturalOrder());
        this.numbers = new Lotto(validIntegerNumbers);
    }

    private void validate(String winningNumbers) {
        try {
            List<String> numbers = List.of(winningNumbers.split(DELIMITER, -1));
            for (String number : numbers) {
                Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_NATURAL_NUMBERS);
        }
    }

    private List<Integer> toIntegerList(String winningNumbersInput) {
        List<Integer> validIntegerNumbers = new ArrayList<>();
        for (String number : winningNumbersInput.split(DELIMITER)) {
            int winningNumber = Integer.parseInt(number);
            validIntegerNumbers.add(winningNumber);
        }
        return validIntegerNumbers;
    }

    public List<Integer> getNumbersList() {
        return numbers.getNumbers();
    }

    public Lotto getNumbers() {
        return numbers;
    }
}
