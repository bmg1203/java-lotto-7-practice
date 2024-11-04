package lotto.view;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.model.LottoConstants.LOTTO_LAST_NUMBER;
import static lotto.model.LottoConstants.LOTTO_START_NUMBER;
import static lotto.validation.Validation.*;

public class InputView {

    public int readPayAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input_pay = readLine().trim();
        try {
            validateStringToInteger(input_pay);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readPayAmount();
        }
        Integer pay = Integer.valueOf(input_pay);
        return pay;
    }

    public Lotto readGoldenNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input_numbers = readLine().trim();
        try {
            validateListStringToInteger(Arrays.asList(input_numbers.split(",")));
            List<Integer> golden_numbers = Arrays.stream(input_numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new Lotto(golden_numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGoldenNumbers();
        }
    }

    public int readBonusNumber(Lotto golden_numbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input_number = readLine().trim();
        try{
            validateStringToInteger(input_number);
            Integer bonus_number = Integer.parseInt(input_number);
            validateNumberInRange(bonus_number, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
            List<Integer> all_numbers = new ArrayList<>(golden_numbers.getNumbers());
            all_numbers.add(bonus_number);
            validateDuplicate(all_numbers);
            return bonus_number;
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readBonusNumber(golden_numbers);
        }
    }
}
