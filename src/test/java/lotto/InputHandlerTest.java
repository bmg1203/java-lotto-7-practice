package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * InputHandlerTest
 */
public class InputHandlerTest {

    InputHandler inputHandler = new InputHandler();
    final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void parse_purchase_amount() {
        String input = "15000";

        int purchaseAmount = inputHandler.parsePurchaseAmount(input);

        assertThat(purchaseAmount).isEqualTo(15_000);
    }

    @Test
    void throw_exception_on_invalid_purchase_amount_input() {
        String input = "2300won";

        Throwable result = catchThrowable(() -> inputHandler.parsePurchaseAmount(input));

        assertIllegalArgumentException(result);
    }

    @Test
    void parse_winning_numbers() {
        String input = "1,2,3,4,5,6";

        List<Integer> winningNumbers = inputHandler.parseWinningNumbers(input);

        assertThat(winningNumbers)
            .hasSize(6)
            .containsAll(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void throw_exception_on_more_or_less_numbers_are_given() {
        String more = "1,2,3,4,5,6,7";
        String less = "1,2,3,4,5";

        Throwable moreResult = catchThrowable(() -> inputHandler.parseWinningNumbers(more));
        Throwable lessResult = catchThrowable(() -> inputHandler.parseWinningNumbers(less));

        assertIllegalArgumentException(moreResult);
        assertIllegalArgumentException(lessResult);
    }

    @Test
    void throw_exception_on_invalid_delimiter_is_given() {
        String invalid = "1;2;3;4;5;6";

        Throwable result = catchThrowable(() -> inputHandler.parseWinningNumbers(invalid));

        assertIllegalArgumentException(result);
    }

    @Test
    void throw_exception_when_numbers_are_not_unique() {
        String notUnique = "1,2,3,1,2,3";

        Throwable result = catchThrowable(() -> inputHandler.parseWinningNumbers(notUnique));

        assertIllegalArgumentException(result);
    }

    @Test
    void parse_bonus_number() {
        String input = "7";

        int bonusNumber = inputHandler.parseBonusNumber(input);

        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    void throw_exception_when_bonus_number_is_not_a_number() {
        String notANumber = "5h3l";

        Throwable result = catchThrowable(() -> inputHandler.parseBonusNumber(notANumber));

        assertIllegalArgumentException(result);
    }

    private void assertIllegalArgumentException(Throwable throwable) {
        assertThat(throwable)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

}
