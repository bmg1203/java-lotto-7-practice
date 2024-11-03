package view;

import static exception.ErrorMessage.INPUT_ONLY_NUMBER;
import static utils.NumberValidation.validateDuplicateNumber;
import static utils.NumberValidation.validateNumberRange;
import static utils.NumberValidation.validateNumberSize;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String CHECK_NUMBER_REGEX = "\\d+";

    private InputView() {
    }

    public static void printPurchaseMessage() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

    public static int purchasePriceInput() {
        String userInput = Console.readLine();
        validateOnlyNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public static List<Integer> winningNumberInput() {
        printBlank();
        System.out.println(WINNING_NUMBER_MESSAGE);
        String userInput = Console.readLine();
        List<Integer> winningNumbers = splitAndConvertUserInput(userInput);
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public static int bonusNumberInput() {
        printBlank();
        System.out.println(BONUS_NUMBER_MESSAGE);
        String userInput = Console.readLine();
        validateBonusNumber(userInput);
        return Integer.parseInt(userInput);
    }

    private static void validateBonusNumber(String userInput) {
        validateOnlyNumber(userInput);
        validateNumberRange(Integer.parseInt(userInput));
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNumberRange(winningNumbers);
        validateDuplicateNumber(winningNumbers);
        validateNumberSize(winningNumbers);
    }

    private static void validateOnlyNumber(String purchasePrice) {
        if (!purchasePrice.matches(CHECK_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER.getMessage());
        }
    }

    private static List<Integer> splitAndConvertUserInput(String userInput) {
        try {
            return List.of(userInput.split(",")).stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER.getMessage());
        }
    }

    private static void printBlank() {
        System.out.println();
    }

}
