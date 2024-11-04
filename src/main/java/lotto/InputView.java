package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Validator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

	public static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> numbers = Arrays.asList(input.split(","));
        Validator.validateWinningNumbers(numbers);
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

	public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        Validator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }

}