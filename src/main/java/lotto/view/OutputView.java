package lotto.view;

import java.util.List;
import lotto.message.RunMessage;

public class OutputView {

    public static void printLottoNumbers(List<Integer> numbers){
        System.out.println(numbers.toString());
    }

    public static void printLottoCount(int amount){
        System.out.printf(RunMessage.PRINT_LOTTO_COUNT.getMessage(), amount);
    }

    public void printWinningStatisticsMessage(int first, int second, int third, int fourth, int fifth, double yield){
        System.out.print(RunMessage.PRINT_WINNING_STATISTIC_MESSAGE.getMessage());
        System.out.printf(RunMessage.PRINT_WINNING_FIFTH.getMessage(),fifth);
        System.out.printf(RunMessage.PRINT_WINNING_FOURTH.getMessage(),fourth);
        System.out.printf(RunMessage.PRINT_WINNING_THIRD.getMessage(),third);
        System.out.printf(RunMessage.PRINT_WINNING_SECOND.getMessage(),second);
        System.out.printf(RunMessage.PRINT_WINNING_FIRST.getMessage(),first);
        System.out.printf(RunMessage.PRINT_WINNING_STATISTIC.getMessage(),yield);
    }
}
