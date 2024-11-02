package lotto.domain;

import static lotto.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import lotto.exception.CustomIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoTicketCalculatorTest {

    private final LottoTicketCalculator calculator = new LottoTicketCalculator();

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("구입 금액이 1000원일 때 1개의 티켓을 구매할 수 있다.")
        public void 티켓이_하나인_경우() {
            PurchaseTotalPrice purchaseTotalPrice = new PurchaseTotalPrice(1000);

            int ticketCount = calculator.getTicketCount(purchaseTotalPrice);

            assertThat(ticketCount).isEqualTo(1);
        }

        @Test
        @DisplayName("구입 금액이 15000원일 때 15개의 티켓을 구매할 수 있다.")
        public void 티켓이_열다섯인_경우() {
            PurchaseTotalPrice purchaseTotalPrice = new PurchaseTotalPrice(15000);

            int ticketCount = calculator.getTicketCount(purchaseTotalPrice);

            assertThat(ticketCount).isEqualTo(15);
        }

        @Test
        @DisplayName("구입 금액이 777000원일 때 777개의 티켓을 구매할 수 있다.")
        public void 티켓이_칠백칠십칠인_경우() {
            PurchaseTotalPrice purchaseTotalPrice = new PurchaseTotalPrice(777000);

            int ticketCount = calculator.getTicketCount(purchaseTotalPrice);

            assertThat(ticketCount).isEqualTo(777);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("구입 금액이 1000원이지만 계산된 티켓 수가 1이 아닐 경우 예외 발생")
        public void 티켓_수가_하나가_아닌_경우() {
            PurchaseTotalPrice purchaseTotalPrice = new PurchaseTotalPrice(1000);

            int ticketCount = calculator.getTicketCount(purchaseTotalPrice);

            if (ticketCount != 1) {
                throw CustomIllegalArgumentException.from(INVALID_TICKET_COUNT);
            }
        }

        @Test
        @DisplayName("구입 금액이 4000원이지만 계산된 티켓 수가 4이 아닐 경우 예외 발생")
        public void 구입_금액이_사천원이지만_예외_발생하는_경우() {
            PurchaseTotalPrice purchaseTotalPrice = new PurchaseTotalPrice(4000);

            int ticketCount = calculator.getTicketCount(purchaseTotalPrice);

            if (ticketCount != 4) {
                throw CustomIllegalArgumentException.from(INVALID_TICKET_COUNT);
            }
        }
    }
}
