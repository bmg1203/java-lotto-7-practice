package lotto.view;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int readMoney() {
        String input = readLine();
        try {
            return convertInputToMoney(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorOfRequestMoney();
            return readMoney();
        }
    }

    private static int convertInputToMoney(String input) throws IllegalArgumentException {
        int money = Integer.parseInt(input);
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public static List<Integer> readNumbers() {
        String input = readLine();
        try {
            return convertInputToNumbers(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorOfRequestNumbers();
            return readNumbers();
        }
    }

    private static List<Integer> convertInputToNumbers(String input) throws IllegalArgumentException {
        String trimmedInput = input.replaceAll(" ", "");
        List<Integer> Numbers = new ArrayList<>();
        for (String rawNumber : trimmedInput.split(",")) {
            Numbers.add(Integer.parseInt(rawNumber));
        }
        return Numbers;
    }

    public static int readNumber() {
        String input = readLine();
        try {
            return convertInputToNumber(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorOfRequestNumber();
            return readNumber();
        }
    }

    private static int convertInputToNumber(String input) throws IllegalArgumentException {
        return Integer.parseInt(input);
    }
}
