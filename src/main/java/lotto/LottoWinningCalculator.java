package lotto;

import java.util.List;
import java.util.Optional;

public class LottoWinningCalculator {
    private LottoWinningCalculator() {
    }

    public static LottoWinningResult calculateWinningResults(LottoTickets lottoTickets, WinningLotto winningLotto) {
        LottoWinningResult results = new LottoWinningResult();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.bonusNumber;

        lottoTickets.getLottoTickets().forEach(ticket -> evaluateTicket(ticket, winningNumbers, bonusNumber, results));
        return results;
    }

    private static void evaluateTicket(Lotto ticket, List<Integer> winningNumbers, int bonusNumber, LottoWinningResult results) {
        int matchCount = countMatchingNumbers(ticket, winningNumbers);
        boolean bonusNumberMatch = ticket.getNumbers().contains(bonusNumber);
        Optional<WinningPrize> winningPrize = WinningPrize.determineWinningPrize(matchCount, bonusNumberMatch);

        if (winningPrize.isPresent()) {
            results.increment(winningPrize.get());
        }
    }

    private static int countMatchingNumbers(Lotto ticket, List<Integer> winningNumbers) {
        return (int) ticket.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
