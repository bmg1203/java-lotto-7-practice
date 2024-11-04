package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.ProfitCalculator;
import lotto.domain.ResultAnalyzer;
import lotto.domain.TicketGenerator;
import lotto.domain.WinningNumbers;

public class LottoService {

    private final TicketGenerator ticketGenerator;
    private final ResultAnalyzer resultAnalyzer;
    private final ProfitCalculator profitCalculator;

    public LottoService(TicketGenerator ticketGenerator, ResultAnalyzer resultAnalyzer,
                        ProfitCalculator profitCalculator) {
        this.ticketGenerator = ticketGenerator;
        this.resultAnalyzer = resultAnalyzer;
        this.profitCalculator = profitCalculator;
    }

    public List<Lotto> purchaseTickets(int ticketCount) {
        return ticketGenerator.generateTickets(ticketCount);
    }

    public Map<LottoRank, Integer> analyzeLottoResults(List<Lotto> purchasedTickets, WinningNumbers winningNumbers) {
        return resultAnalyzer.getRankCounts(purchasedTickets, winningNumbers);
    }

    public double calculateProfitRate(Map<LottoRank, Integer> results, int purchaseAmount) {
        return profitCalculator.calculateProfitRate(results, purchaseAmount);
    }
}
