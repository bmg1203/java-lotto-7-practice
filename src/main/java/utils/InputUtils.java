package utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class InputUtils {
    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 45;
    private static final int LOTTO_TOTAL_COUNT = 6;


    public static String getInput() {
        return Console.readLine();
    }


    public static List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, LAST_NUMBER, LOTTO_TOTAL_COUNT);
    }


    public static String deleteBlank(String input) {
        input = input.strip();
        return input;
    }


}
