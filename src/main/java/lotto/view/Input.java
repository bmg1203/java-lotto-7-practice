package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getInput() {
        return Console.readLine().replace(" ", "");
    }
}
