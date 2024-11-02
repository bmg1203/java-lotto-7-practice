package lotto.domain;

import java.util.List;
import lotto.util.enums.ValidateMessage;

public class Bonus {
    private static final int FORTY_FIVE = 45;
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";

    private int number;

    public Bonus(int number, List<Integer> lottoNumbers) {
        validateOverThanFortyFive(number);
        validateDistinctWithLotto(number ,lottoNumbers);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateOverThanFortyFive(int number) {
        if (number > FORTY_FIVE) {
            throw new IllegalArgumentException(ValidateMessage.NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void validateDistinctWithLotto(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(
                    ValidateMessage.SAME_WITH_LOTTO_NUMBER_ERROR.getMessage()
                            + LEFT_PARENTHESIS
                            + number
                            + RIGHT_PARENTHESIS
            );
        }
    }
}
