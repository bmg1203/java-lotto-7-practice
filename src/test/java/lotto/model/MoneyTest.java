package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.LottoPurchaseMoneyErrorMessage;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @Test
    void Money_생성_테스트() {
        // given
        Money money = new Money("39000");

        // when
        int result = money.getMoney();

        // then
        assertThat(result).isEqualTo(39000);
    }

    @Test
    void getMoney_금액_반환() {
        // given
        Money money = new Money("39000");

        // when
        int result = money.getMoney();

        // then
        assertThat(result).isEqualTo(39000);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2"})
    void getLottoCount_로또_개수_반환(String rawInput, int expected) {
        // given
        Money money = new Money(rawInput);

        // when
        int result = money.getLottoCount();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void validateIsNumber_문자_예외() {
        assertThatThrownBy(() -> {
            // given
            Money money = new Money("miku");

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoPurchaseMoneyErrorMessage.NOT_INTEGER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-393939"})
    void validateIsPositive_양수_아님_예외(String rawInput) {
        assertThatThrownBy(() -> {
            // given
            Money money = new Money(rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoPurchaseMoneyErrorMessage.NOT_POSITIVE.getMessage());
    }


    @ParameterizedTest
    @ValueSource(strings = {"999", "1001", "1039", "1003"})
    void validateIsMultipleOf1000_1000원_단위_아님_예외(String rawInput) {
        assertThatThrownBy(() -> {
            // given
            Money money = new Money(rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoPurchaseMoneyErrorMessage.NOT_MULTIPLE_OF_1000.getMessage());
    }

    @Test
    void validateIsLessThanMaximum_1억_초과_예외() {
        assertThatThrownBy(() -> {
            // given
            Money money = new Money("1000001000");

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoPurchaseMoneyErrorMessage.OVER_1BILLION.getMessage());
    }

    @Test
    void validateIsLessThanMaximum_1억_이하() {
        // given
        Money money = new Money("1000000000");

        // when
        int result = money.getMoney();

        // then
        assertThat(result).isEqualTo(1_000_000_000);
    }

    @Test
    void getReturnOfRate_수익률_계산() {
        // given
        Money money = new Money("1000");

        // when
        double result = money.getReturnOfRate(5000L);

        // then
        assertThat(result).isEqualTo(5.0);
    }

}