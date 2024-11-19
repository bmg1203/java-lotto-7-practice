package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private Purchase purchase;

    @BeforeEach
    public void setPurchase() {
        int money = 8000;
        purchase = new Purchase(money);
    }

    @Test
    void 정상_동작_테스트() {
        //given, when
        LottoGenerator lottoGenerator = new LottoGenerator(purchase);

        //then
        assertThat(lottoGenerator.getLottos().size()).isEqualTo(purchase.purchaseCount());
    }
}