package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.IntegerParser;
import lotto.util.Validator;

import java.util.List;

public class InputView {

    private final Validator validator;
    private final IntegerParser integerParser;

    public InputView() {
        this.validator = new Validator();
        this.integerParser = new IntegerParser();
    }

    public int readPriceInput(){
        String input = Console.readLine();
        while (!validator.validatePrice(input)) {
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

    public List<Integer> readWinningNumberInput(){
        String input = Console.readLine();
        while (!validator.validateWinningNumber(input)) {
            input = Console.readLine();
        }
        return integerParser.stringToIntegerList(input);
    }

    public int readBonusNumberInput(List<Integer> winningNumbers){
        String input = Console.readLine();
        while (!validator.validateBonusNumber(input, winningNumbers)){
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

}
