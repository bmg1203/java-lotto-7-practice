package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketFactoryTest {

    @DisplayName("돈을 1000원 단위로 입력하면 로또 갯수를 알려주는 getLottoTicketCount 메서드")
    @ParameterizedTest
    @ValueSource(strings = {"8000", "10000"})
    void getLottoTicketCountTest(String money) {
        int lottoTickets = LottoTicketFactory.getLottoTicketCount(money);
        assertTrue(lottoTickets > 0);
    }

    @DisplayName("돈을 1000원 미만 단위로 입력하면 exception 나오는 getLottoTicketCount 메서드")
    @ParameterizedTest
    @ValueSource(strings = {"8800", "100", "11111111"})
    void getLottoTicketCountExceptionTest(String money) {
        assertThatThrownBy(() -> LottoTicketFactory.getLottoTicketCount(money)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("[ERROR]");

    }

    @DisplayName("돈을 숫자 이외의 문자가 들어갈 경우의 Exception")
    @ParameterizedTest
    @ValueSource(strings = {"1000l"})
    void isNumericExceptionTest(String money) {
        assertThatThrownBy(() -> LottoTicketFactory.isNumeric(money)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("돈을 숫자로만 이루어진 문자가 들어갈 경우의 Exception")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "8000"})
    void isNumericTest(String money) {
        assertTrue(LottoTicketFactory.isNumeric(money) > 0);
    }
}
