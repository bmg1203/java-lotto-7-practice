package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.FormatException;
import lotto.exception.FormatExceptionType;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int getValue() {
        System.out.println(INPUT_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new FormatException(FormatExceptionType.INVALID_INPUT_FORMAT);
        }
    }

    public static List<Integer> getLottoNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException numberFormatException) {
            throw new LottoException(LottoExceptionType.INVALID_WINNING_NUMBERS);
        }
    }

    public int getBonusLottoNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new FormatException(FormatExceptionType.INVALID_NUMBER_FORMAT);
        }
    }

}
