package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.util.ProfitCalculator;
import lotto.validator.LottoValidator;

public class LottoService {

  private static final int LOTTO_PRICE = 1000;

  public LottoTicket generateLottoTickets(int amount) {
    LottoValidator.validatePurchaseAmount(amount);
    int ticketCount = amount / LOTTO_PRICE;
    List<Lotto> tickets = new ArrayList<>();

    for (int i = 0; i < ticketCount; i++) {
      tickets.add(new Lotto(LottoNumberGenerator.generateRandomNumbers()));
    }
    return new LottoTicket(tickets);
  }

  public Map<Rank, Long> calculateRanks(LottoTicket lottoTicket, WinningLotto winningLotto) {
    return lottoTicket.getTickets().stream()
        .map(winningLotto::calculateRank)
        .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
  }

  public double calculateProfitRate(int investment, int totalPrize) {
    return ProfitCalculator.calculateProfitRate(investment, totalPrize);
  }
}
