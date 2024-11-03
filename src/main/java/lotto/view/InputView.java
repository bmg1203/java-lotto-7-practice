package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoParser;
import lotto.util.Validator;

import java.util.List;

public class InputView {

    public int readPurchasePrice() {
        while (true) {
            try {
                String input = getInput();
                Validator.validateNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readPickNumbers() {
        while (true) {
            try {
                String input = getInput();
                Validator.validateCommaSeparatedNumbers(input);
                return LottoParser.parse(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumber() {
        while (true) {
            try {
                String input = getInput();
                Validator.validateNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getInput() {
        return Console.readLine();
    }
}
