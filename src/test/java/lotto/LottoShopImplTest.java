package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopImplTest {
    private LottoMachine lottoMachine;
    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoMachineImpl();
    }
    @DisplayName("로또 구매 금액만큼 알맞은 수량으로 로또가 반환된다")
    @Test
    void 로또_구매() {
        //given
        int purchaseAmount = 7000;
        //when
        LottoShopImpl lottoShopImpl = new LottoShopImpl(lottoMachine);
        List<Lotto> lottos = lottoShopImpl.publish(purchaseAmount);
        //then
        Assertions.assertThat(lottos.size()).isEqualTo(7);
    }
}