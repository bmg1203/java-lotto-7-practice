package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.ErrorMessage;
import org.junit.jupiter.api.Test;

public class PaymentValidatorTest {

    @Test
    void 구매_금액이_천_단위가_아닐_경우() {
        // given
        Integer money = 1500;

        // when
        assertThatThrownBy(() -> PaymentValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PAYMENT_ERROR_IN_MULTIPLE_OF_THOUSAND); // then
    }
}
