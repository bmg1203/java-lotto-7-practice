package lotto.view;

import static lotto.utils.Constants.MAX_NUMBER;
import static lotto.utils.Constants.THOUSAND_VALUE;
import static lotto.utils.Constants.ZERO_VALUE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.ErrorMessage;

public class InputView {
    private static final String INPUT_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public int inputMoneyAmount() {
        System.out.println(INPUT_MONEY_AMOUNT);
        while (true) {
            try {
                int input = parseIntInputString();
                validateInputMoney(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        while (true) {
            try {
                List<String> inputString = List.of(Console.readLine().split(DELIMITER));
                List<Integer> inputNumbers = convertStringToInteger(inputString);
                validateNumberQuantity(inputNumbers);
                validateDuplicatedNumber(inputNumbers);
                return inputNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(INPUT_BONUS_NUMBER);
        while (true) {
            try {
                int input = parseIntInputString();
                validateInputNumber(input);
                validateDuplicatedFromWinningNumbers(input, winningNumbers);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected List<Integer> convertStringToInteger(List<String> inputString) {
        List<Integer> inputNumbers = new ArrayList<>();
        int num = ZERO_VALUE;
        for (String input : inputString) {
            try {
                num = Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_STRING_FORMAT.getMessage());
            }
            int inputNumber = validateInputNumber(num);
            inputNumbers.add(inputNumber);
        }
        return inputNumbers;
    }

    protected void validateDuplicatedFromWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    protected int parseIntInputString() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    protected void validateNumberQuantity(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    protected void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    protected int validateInputNumber(int number) {
        if (number <= ZERO_VALUE || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
        return number;
    }

    protected void validateInputMoney(int money) {
        if (money <= ZERO_VALUE || money % THOUSAND_VALUE != ZERO_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }
}
