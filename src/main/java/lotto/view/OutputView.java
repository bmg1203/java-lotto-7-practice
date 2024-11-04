package lotto.view;

import lotto.global.enums.PrintMessage;
import lotto.model.Lotto;
import lotto.model.WinningCount;

import java.text.MessageFormat;
import java.util.List;

import static lotto.global.enums.PrintMessage.RATE_OF_RETURN;
import static lotto.global.enums.PrintMessage.WINNING_RESULT;

public class OutputView {
    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(PrintMessage message) {
        System.out.println(message.getMessage());
    }

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public String formattingMessage(PrintMessage message, Object objects) {
        return MessageFormat.format(message.getMessage(), objects);
    }

    public String formattingMessage(PrintMessage printMessage, Object[] objects) {
        return MessageFormat.format(printMessage.getMessage(), objects);
    }

    public void printWinningResult(WinningCount count) {
        List<Integer> winningCount = count.getWinningCount();
        String message = formattingMessage(WINNING_RESULT, winningCount.toArray());
        printMessage(message);
    }

    public void printRateOfReturn(double rateOfReturn) {
        String message = formattingMessage(RATE_OF_RETURN, rateOfReturn);
        printMessage(message);
    }
}
