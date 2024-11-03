package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoInputView {
    public int validateMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money <= 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0보다 커야 합니다.");
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public int readMoney() {
        String input = Console.readLine();
        return validateMoney(input);
    }
    public List<Integer> validateWinningNumbers(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)로 구분해야 합니다.");
        }

        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        return convertToNumbers(numbers);
    }

    private List<Integer> convertToNumbers(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    public String readWinningNumbers() {
        String input = Console.readLine();
        return input;
    }
}