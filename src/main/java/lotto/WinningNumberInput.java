package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumberInput {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void inputWinningNumbers() {
        while (true) {
            try {
                String input = requestWinningNumbers();
                winningNumbers = parseWinningNumbers(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                int input = requestBonusNumber();
                validateBonusNumber(input);
                bonusNumber = input;
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    private List<Integer> parseWinningNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (numbers.size() != 6 || !isUniqueAndInRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이의 중복되지 않는 숫자 6개여야 합니다.");
        }
        return numbers;
    }

    private boolean isUniqueAndInRange(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == 6 && numbers.stream().allMatch(num -> num >= 1 && num <= 45);
    }

    private int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }

    private void validateBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
