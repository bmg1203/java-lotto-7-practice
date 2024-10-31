package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("Money 객체 생성 O 테스트")
    @Test
    void createMoneyTrue() {
        //given
        String money = "14000";

        //when
        Money actual = Money.from(money);

        //then
        assertThat(actual).isNotNull();
    }

    @DisplayName("Money 객체 생성 X 테스트")
    @Test
    void createMoneyFalse() {
        //given
        String money = "140";

        //when

        //then
        assertThatThrownBy(() -> Money.from(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 구입 금액은 1000보다 작을 수 없습니다.");
    }
}