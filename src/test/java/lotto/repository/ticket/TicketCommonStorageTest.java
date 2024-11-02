package lotto.repository.ticket;

import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.ticket.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TicketCommonStorage - 티켓 공용 저장소")
class TicketCommonStorageTest {

    @Test
    @DisplayName("저장소 싱글톤 인스턴스 조회")
    void 저장소_싱글톤_인스턴스_조회() {
        // when
        ConcurrentHashMap<Long, Ticket> repository1 = TicketCommonStorage.getRepository();
        ConcurrentHashMap<Long, Ticket> repository2 = TicketCommonStorage.getRepository();

        // expect
        Assertions.assertThat(repository1).isSameAs(repository2);
    }
}
