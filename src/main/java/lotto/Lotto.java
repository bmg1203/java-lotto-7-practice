package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto getWinningNumbers() {
        String numbersInput = InputHandler.getUserInput();

        try {
            return Lotto.getNumbersFromInput(numbersInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "다시 입력해 주세요.");
            return getWinningNumbers();
        }
    }

    public static int getBonusNumber(Lotto winningNumbers) {
        String numberInput = InputHandler.getUserInput();
        try {
            return getBonusNumberFromInput(winningNumbers, numberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " 다시 입력해 주세요.");
            return getBonusNumber(winningNumbers);
        }
    }

    public static void printRequestingLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestingBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static Lotto getNumbersFromInput(String userInput) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] numbers = userInput.split(",", -1);

        for (String number : numbers) {
            int validatedNumber = Validator.validateLottoNumber(number);
            winningNumbers.add(validatedNumber);
        }

        return new Lotto(winningNumbers);
    }

    private static int getBonusNumberFromInput(Lotto numbers, String userInput) {
        int bonusNumber = Validator.validateLottoNumber(userInput);
        Validator.validateBonusNumber(numbers, bonusNumber);

        return bonusNumber;
    }

    public static int numberMatchCount(Lotto numbers, List<Integer> randomLotto) {
        int numberMatch = 0;

        for (int winningNumber : numbers.getNumbers()) {
            if (randomLotto.contains(winningNumber)) {
                numberMatch += 1;
            }
        }

        return numberMatch;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
