package lotto.view.InputProvider;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class ConsoleInputProvider implements InputProvider {

    public static final String INPUT_FAILURE_MESSAGE = "입력을 받는데 실패했습니다.";

    @Override
    public String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException error) {
            throw new NoSuchElementException(INPUT_FAILURE_MESSAGE);
        } catch (IllegalStateException error) {
            throw new IllegalStateException(INPUT_FAILURE_MESSAGE);
        }
    }

    @Override
    public void close() {
        Console.close();
    }

}
