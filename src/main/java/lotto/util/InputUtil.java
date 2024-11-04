package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    static final String DELIMITER = ",";

    public static String readInput() {
        String input = Console.readLine();
        Validator.validateNullInput(input);
        Validator.validateWhitespaceInput(input);
        return input;
    }

    public static List<Integer> parseInputToLottoList(String input) {
        Validator.validateRightDelimiter(input);
        String[] numbers = input.split(DELIMITER);
        List<Integer> lottoList = new ArrayList<>();
        for (String number : numbers) {
            Validator.validateNullInput(number);
            Validator.validateWhitespaceInput(number);
            int num = Validator.validateLottoNumber(number);
            lottoList.add(num);
        }
        return lottoList;
    }

    public static int convertStringToInt(String input) {
        Validator.validateRightNumber(input);
        return Validator.validateLottoNumber(input);
    }
}
