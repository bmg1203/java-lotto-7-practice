package lotto.utils.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.constants.ErrorMessage;
import lotto.utils.validator.AmountsValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountsParserTest {

    @ParameterizedTest
    @DisplayName("1000원보다 적은 금액이 입력되면, 예외가 발생한다.")
    @ValueSource(strings = "999")
    void Given_AmountsAreOverMinAmounts_When_CheckMinAmounts_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsParser.getAmounts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNDER_MIN_AMOUNTS.getMessage());
    }

    @ParameterizedTest
    @DisplayName("10만원이 넘는 금액이 입력되면, 예외가 발생한다.")
    @ValueSource(strings = "100001")
    void Given_AmountsAreOverMaxAmounts_When_CheckMaxAmounts_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsParser.getAmounts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OVER_MAX_AMOUNTS.getMessage());
    }

    @ParameterizedTest
    @DisplayName("1000원 단위가 아닌 금액이 입력되면, 예외가 발생한다.")
    @ValueSource(strings = "1100")
    void Given_AmountsCanNotDivideByThousand_When_CheckDivisibilityByThousand_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsParser.getAmounts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_DIVISIBLE_BY_THOUSAND_WON.getMessage());
    }

}