package lotto.model;

import static lotto.enums.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.enums.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.enums.LottoConstant.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PurchaseTest {
    @Test
    void 금액에_맞는_개수의_로또를_발행한다() {
        // given
        String paymentInput = "8000";

        // when
        Purchase purchase = new Purchase(paymentInput);
        int lottoCount = purchase.getLottoCount();

        // then
        assertThat(lottoCount).isEqualTo(8);
    }

    @Test
    void 발행된_로또번호는_중복이아닌_6개의_범위내의숫자이다() {
        // given
        String paymentInput = "10000";

        // when
        Purchase purchase = new Purchase(paymentInput);
        List<Lotto> lottoTickets = purchase.getPurchasedLottoTickets();

        // then
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(LOTTO_NUMBER_COUNT.getNumber());
            assertThat(numbers).allMatch(
                    number -> number >= MIN_LOTTO_NUMBER.getNumber() && number <= MAX_LOTTO_NUMBER.getNumber());
            assertThat(numbers).doesNotHaveDuplicates();
        }
    }
}