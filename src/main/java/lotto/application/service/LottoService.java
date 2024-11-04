package lotto.application.service;

import lotto.application.dto.LottoTicketsDTO;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoTickets;
import lotto.infrastructure.repository.LottoRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final int LOTTO_TICKET_PRICE = 1000;

    private final LottoNumberGenerator numberGenerator;
    private final LottoRepository lottoRepository;

    public LottoService(LottoNumberGenerator numberGenerator, LottoRepository lottoRepository) {
        this.numberGenerator = numberGenerator;
        this.lottoRepository = lottoRepository;
    }
    public void purchaseLotto(int amount) {
        int ticketCount = amount / LOTTO_TICKET_PRICE;
        List<Lotto> tickets = generateLottoTickets(ticketCount);
        LottoTickets lottoTickets = new LottoTickets(tickets);
        lottoRepository.save(lottoTickets);
    }
    public LottoTickets getLottoTicketsFromRepository() {
        return lottoRepository.findAll();
    }

    private List<Lotto> generateLottoTickets(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(numberGenerator.generate().stream().sorted().collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
