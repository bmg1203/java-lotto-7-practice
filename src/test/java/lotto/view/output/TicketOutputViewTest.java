package lotto.view.output;

import java.util.List;
import lotto.dto.TicketResult;
import org.junit.jupiter.api.Test;

class TicketOutputViewTest {

    @Test
    void 동작테스트() {
        TicketResult ticketResult = new TicketResult(2, List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        ));
        TicketOutputView ticketOutputView = new TicketOutputView();
        ticketOutputView.show(ticketResult);
    }
}
