package lotto.service.ticket;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.Ticket;
import lotto.repository.ticket.TicketCommonStorage;
import lotto.repository.ticket.TicketReadRepository;
import lotto.repository.ticket.TicketWriteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoReadService - 로또 조회 서비스")
class TicketReadServiceTest {

    @BeforeEach
    void setUp() {
        TicketCommonStorage.clear();
    }


    private Ticket createTicket(Long id) {
        return Ticket.issue(id, createLottos());
    }

    private Lottos createLottos() {
        return Lottos.of(List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6))
        ));
    }


    @DisplayName("티켓 Id로 티켓 조회 성공")
    @Test
    void 티켓_Id로_티켓_조회_성공() {
        // given
        TicketWriteRepository ticketWriteRepository = new TicketWriteRepository();
        TicketReadRepository ticketReadRepository = new TicketReadRepository();
        TicketReadService ticketReadService = new TicketReadService(ticketReadRepository);

        Long saveId = ticketWriteRepository.save(createTicket(1L));
        long ticketId = 1L;

        // when
        Ticket foundTicket = ticketReadService.getById(ticketId);

        // then
        assertThat(foundTicket.getId()).isEqualTo(saveId);
    }

    @DisplayName("없는 티켓Id로 조회 실패")
    @Test
    void 없는_티켓Id로_조회_실패() {
        // given
        TicketReadRepository ticketReadRepository = new TicketReadRepository();
        TicketReadService ticketReadService = new TicketReadService(ticketReadRepository);

        // expect
        Assertions.assertThatThrownBy(() -> ticketReadService.getById(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 존재 하지 않는 티켓 ID 입니다.");
    }

}
