package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    void 반환_받은_로또_티켓_변경_시도_예외() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
            LottoTickets lottoTickets = new LottoTickets(Arrays.asList(lotto));
            lottoTickets.getLottoTickets().add(new Lotto(Arrays.asList(11, 22, 33, 34, 43, 45)));
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}