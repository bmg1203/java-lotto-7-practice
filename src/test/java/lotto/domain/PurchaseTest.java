package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseTest {

    @Test
    void 정상_동작_테스트() {
        //given
        int input = 4000;

        //when
        Purchase purchase = new Purchase(input);

        //then
        assertThat(purchase.getMoney()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {800, -1000, 1500})
    void 예외_테스트(int input) {
        //when, then
        assertThatThrownBy(() -> new Purchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_개수_테스트() {
        //given
        int input = 5000;

        //when
        Purchase purchase = new Purchase(input);

        //then
        assertThat(purchase.purchaseCount()).isEqualTo(5);
    }
}