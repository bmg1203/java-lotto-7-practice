package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

import static lotto.constants.LottoConstants.*;

public class InputHandler {
    public int budgetInput() {
        while (true) {
            try {
                int price = Integer.parseInt(Console.readLine());
                budgetInputValidator(price);
                return price;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void budgetInputValidator(int price) {
        if (price % LOTTO_PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위만 가능합니다.");
        }
        if (price < LOTTO_PURCHASE_UNIT) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000 이상부터 가능합니다.");
        }
    }

    public Lotto winningNumbersInput() {
        while (true) {
            try {
                List<String> rawNumbers = Arrays.asList(Console.readLine().split(","));
                List<Integer> winningNumbers = convertRawNumbers();
                Lotto lotto = new Lotto(winningNumbers);
                return lotto;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> convertRawNumbers(List<String> rawNumbers){
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : rawNumbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    public int bonusNumberInput(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                bonusNumberValidator(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void bonusNumberValidator(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스번호는 1~45사이의 정수여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 보너스번호와 중복된 숫자가 존재합니다.");
        }
    }

}
