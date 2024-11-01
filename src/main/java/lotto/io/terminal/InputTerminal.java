package lotto.io.terminal;

import lotto.io.exception.InputException;
import lotto.io.preprocessor.IOPreprocessor;
import lotto.model.lotto.Lotto;
import lotto.model.money.Money;

public class InputTerminal {

    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_DRAW_RESULT = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final Writer writer;
    private final Reader reader;

    private InputTerminal(final Writer writer, final Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public static class TerminalHolder {
        private static final InputTerminal INSTANCE = new InputTerminal(
                Writer.initiate(),
                Reader.initiate()
        );
    }

    public static InputTerminal getInstance() {
        return TerminalHolder.INSTANCE;
    }

    public Money readPurchaseAmount() {
        while (true) {
            try {
                writer.simplePrint(ENTER_PURCHASE_AMOUNT);
                String input = reader.readInput();
                // TODO : Validation
                return IOPreprocessor.stringToMoney(input);
            } catch (InputException e) {
                writer.printErrorMessage(e.getMessage());
            }
        }
    }

    public Lotto readDrawResult() {
        while (true) {
            try {
                writer.printWithNewLineBefore(ENTER_DRAW_RESULT);
                String input = reader.readInput();
                // TODO : Validation
                return IOPreprocessor.stringToLotto(input);
            } catch (InputException e) {
                writer.printErrorMessage(e.getMessage());
            }
        }
    }

    public Integer readBonusNumber() {
        while (true) {
            try {
                writer.printWithNewLineBefore(ENTER_BONUS_NUMBER);
                String input = reader.readInput();
                // TODO : Validation
                return IOPreprocessor.stringToInteger(input);
            } catch (InputException e) {
                writer.printErrorMessage(e.getMessage());
            }
        }
    }
}
