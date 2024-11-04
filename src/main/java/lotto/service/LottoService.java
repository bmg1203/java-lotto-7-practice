package lotto.service;


import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.utils.ProfitCalculator;
import lotto.domain.Ticket;
import lotto.domain.WinningPrice;
import java.util.List;
import java.util.Map;
import lotto.utils.RandomNumber;
import lotto.utils.WinningCalculator;

public class LottoService {

    private final LottoResult lottoResult;
    private Ticket ticket;

    public LottoService(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int calculateTicketQuantity(int purchaseAmount) {
        ticket = Ticket.from(purchaseAmount);
        return ticket.getQuantity();
    }

    public List<List<Integer>> generateLottoNumber(int ticketQuantity) {
        return IntStream.range(0, ticketQuantity)
                .mapToObj(i -> new Lotto(RandomNumber.create()).getNumbers())
                .collect(Collectors.toList());
    }

    public void calculateWinningStatistics(List<Integer> winningNumbers, List<List<Integer>> lottos,
            int bonusNumber) {
        for (List<Integer> lotto : lottos) {
            calculatePrizeForLotto(winningNumbers, bonusNumber, lotto);
        }
    }

    public Map<WinningPrice, Integer> getLottoResult() {
        return lottoResult.getResult();
    }

    public String getProfit() {
        return ProfitCalculator.rate(lottoResult.getResult(), ticket.getPurchaseAmount());
    }

    private void calculatePrizeForLotto(List<Integer> winningNumbers, int bonusNumber,
            List<Integer> lotto) {
        int matchCount = WinningCalculator.countMatchingNumber(winningNumbers, lotto);
        boolean bonusNumberMatched = WinningCalculator.isBonusNumberMatched(lotto, bonusNumber);
        WinningPrice winningPrice = WinningPrice.of(matchCount, bonusNumberMatched);
        lottoResult.increaseWinningCount(winningPrice);
    }
}
