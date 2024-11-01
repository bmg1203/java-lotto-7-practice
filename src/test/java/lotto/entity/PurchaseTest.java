package lotto.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    // 티켓 수 테스트

    @Test
    void 성공__사용자가_출력할수있는_티켓_수_1개() {
        // given
        int money = 1000;

        // when
        Purchase purchase = new Purchase(money);

        // then
        Assertions.assertEquals(1, purchase.calculateTicketCount());
    }

    @Test
    void 성공__사용자가_출력할수있는_티켓_수_2개() {
        // given
        int money = 2000;

        // when
        Purchase purchase = new Purchase(money);

        // then
        Assertions.assertEquals(2, purchase.calculateTicketCount());
    }

    @Test
    void 성공__사용자가_출력할수있는_티켓_수_100개() {
        // given
        int money = 100_000;

        // when
        Purchase purchase = new Purchase(money);

        // then
        Assertions.assertEquals(100, purchase.calculateTicketCount());
    }

    // 결제한 금액 테스트

    @Test
    void 성공__사용자가_결제한_금액() {
        // given
        int money = 1000;

        // when
        Purchase purchase = new Purchase(money);

        // then
        Assertions.assertEquals(1000, purchase.getAmount());
    }

    // 예외 테스트들

    @Test
    void 실패__사용자가_결제한_금액이_로또가격보다_작을때() {
        // given
        int money = 500;

        // when
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또 가격보다 적은 금액입니다.", exception.getMessage());
    }

    @Test
    void 실패__사용자가_결제한_금액이_1000원_단위가_아닐때_입력_1001() {
        // given
        int money = 1001;

        // when
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또 가격은 1000원 단위로만 가능합니다.", exception.getMessage());
    }

    @Test
    void 실패__사용자가_결제한_금액이_1000원_단위가_아닐때_입력_1999() {
        // given
        int money = 1999;

        // when
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또 가격은 1000원 단위로만 가능합니다.", exception.getMessage());
    }

    @Test
    void 실패__사용자가_결제한_금액이_1000원_단위가_아닐때_입력_11001() {
        // given
        int money = 11001;

        // when
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또 가격은 1000원 단위로만 가능합니다.", exception.getMessage());
    }

    @Test
    void 실패__사용자가_결제한_금액이_10만원이_초과될_경우() {
        // given
        int money = 101_000;

        // when
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Purchase(money));

        // then
        Assertions.assertEquals("로또는 한번에 10만원 까지 구입 가능합니다.", exception.getMessage());
    }

    @Test
    void 성공__사용자가_결제한_금액_확인() {
        // given
        int money = 1000;

        // when
        Purchase purchase = new Purchase(money);

        // then
        Assertions.assertEquals(1000, purchase.getAmount());
    }

}
