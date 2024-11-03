package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoDraw {
    private static List<Integer> splitAndTrimInput(String input) {
        List<Integer> numberList = new ArrayList<>();
        String[] parts = input.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        parseStringToInteger(parts, numberList);
        return numberList;
    }

    private static void parseStringToInteger(String[] parts, List<Integer> numberList) {
        for (String part : parts) {
            try {
                numberList.add(Integer.parseInt(part));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 정수이어야 합니다.");
            }
        }
    }

    public static Lotto inputWinnigNumbers() {
        while (true) {
            String input = Console.readLine();
            Lotto winningNumbers = makeWinningNumbersToLotto(input);
            if (winningNumbers != null) {
                return winningNumbers;
            }
        }
    }

    private static Lotto makeWinningNumbersToLotto(String input) {
        try {
            Lotto winningNumbers = new Lotto(splitAndTrimInput(input));
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<Integer> inputBonusNumber(Lotto winningNumbers) {
        while (true) {
            String input = Console.readLine();
            List<Integer> bonusNumber = makeBonusNumberToList(input, winningNumbers);
            if (bonusNumber != null) {
                return bonusNumber;
            }
        }
    }

    private static List<Integer> makeBonusNumberToList(String input, Lotto winningNumbers) {
        try {
            List<Integer> bonusNumber = splitAndTrimInput(input);
            if (validateBonusNumber(bonusNumber, winningNumbers)) {
                return bonusNumber;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
