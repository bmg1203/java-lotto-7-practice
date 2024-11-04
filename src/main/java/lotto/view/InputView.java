package lotto.view;

import static lotto.util.message.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.util.message.InputMessage.INPUT_TOTAL_COST;
import static lotto.util.message.InputMessage.INPUT_WINNING_LOTTO_NUMBER;
import static lotto.util.validator.InputValidator.validateBlank;
import static lotto.util.validator.LottoNumberValidator.validateInputString;
import static lotto.util.validator.LottoNumberValidator.validateNumberInRange;
import static lotto.util.validator.TotalCostValidator.validateDividedByLottoPrice;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public Long inputTotalCost() {
        System.out.println(INPUT_TOTAL_COST);
        String input = validateBlank(Console.readLine());

        return validateDividedByLottoPrice(input);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER);
        List<String> input = validateInputString(Console.readLine());

        return input.stream()
                .map(s -> validateNumberInRange(s.trim()))
                .map(Long::intValue)
                .toList();
    }

    public Long inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = validateBlank(Console.readLine());

        return validateNumberInRange(input);
    }
}
