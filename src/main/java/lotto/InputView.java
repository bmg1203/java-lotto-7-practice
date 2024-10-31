package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String PRIZE_NUMBERS_SPLIT_STRING = ",";

    public static int inputPurchaseAmount() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_INPUT.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputLottoPrizeNumbers() {
        System.out.println(InputMessage.PRIZE_NUMBERS_INPUT.getMessage());
        return Arrays.stream(Console.readLine().split(PRIZE_NUMBERS_SPLIT_STRING))
                .map(Integer::parseInt)
                .toList();
    }
}
