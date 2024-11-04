package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.Util;
import lotto.validator.Validator;

public class InputView {
    private final Validator validator = new Validator();

    public String input(String message) {
        System.out.println(message);
    public List<Integer> lottoInput(String message) {
        String input = "";
        do {
            input = input(message);
        } while (!(validator.validateLotto(input)));
        return Util.stringToInt(input);
    }
}
