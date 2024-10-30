package lotto.domain;

import lotto.utils.TestNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest {

    @Test
    void 구입_금액_만큼_로또를_생성한다(){
        TestNumbersGenerator testNumbersGenerator = new TestNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));
        LottoStore lottoStore = new LottoStore(testNumbersGenerator);

        LottoTicket lottoTicket = lottoStore.buyLottoTicket(3000);

        Assertions.assertThat(lottoTicket.getLottos().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 999, -1})
    void 구입_금액이_1000원_딘위가_아니면_예외가_발생한다(int price){
        TestNumbersGenerator testNumbersGenerator = new TestNumbersGenerator(List.of(1, 2, 3, 4, 5, 6));
        LottoStore lottoStore = new LottoStore(testNumbersGenerator);

        assertThatThrownBy(() -> lottoStore.buyLottoTicket(price))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
