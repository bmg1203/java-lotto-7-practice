package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.Input;

public class ConsoleInput implements Input {

    @Override
    public String getPurchaseAmount() {
        return Console.readLine();
    }

    @Override
    public String getWinningLotto() {
        return Console.readLine();
    }

    @Override
    public String getBonusNumber() {
        return Console.readLine();
    }
}
