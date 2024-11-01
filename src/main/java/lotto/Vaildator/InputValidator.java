package lotto.Vaildator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void valid(List<Integer> numbers) {
        validSize(numbers);
        validPositive(numbers);
        validRange(numbers);
    }

    private static void validSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validInput(String input) {
        validEmpty(input);
        validDuplicate(input);
    }

    private static void validEmpty(String input) {
        String[] splitNumbers = input.split(",");
        for (String number : splitNumbers) {
            String trimmedNumber = number.trim();
            if (trimmedNumber.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 빈 값은 포함할 수 없습니다.");
            }
            if (!trimmedNumber.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 숫자 외 문자 혹은 공백은 포함할 수 없습니다.");
            }
        }
    }

    private static void validDuplicate(String input) {
        String[] splitNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitNumbers) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어 있습니다.");
        }
    }

    private static void validPositive(List<Integer> numbers) {
        for (int num : numbers) {
            if (num <= 0) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 양수여야 합니다.");
            }
        }
    }

    private static void validRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45여야 합니다.");
            }
        }
    }
}