package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class ResultGenerator {

    private final List<Integer> winningResult = new ArrayList<>();
    private final List<Integer> bonusResult = new ArrayList<>();

    public ResultGenerator(List<Lotto> lottoTicket, Lotto winning, Bonus bonus) {
        compareTicketToWinning(lottoTicket, winning);
        compareTicketToBonus(lottoTicket, bonus);
    }

    private void compareTicketToWinning(List<Lotto> lottoTicket, Lotto winning) {
        lottoTicket.forEach(lotto -> countWinning(lotto, winning));
    }

    private void countWinning(Lotto lotto, Lotto winning) {
        winningResult.add((int) lotto.getNumbers().stream()
                .filter(number -> winning.getNumbers().contains(number))
                .count());
    }

    private void compareTicketToBonus(List<Lotto> lottoTicket, Bonus bonus) {
        lottoTicket.forEach(lotto -> countBonus(lotto, bonus));
    }

    private void countBonus(Lotto lotto, Bonus bonus) {
        if (lotto.getNumbers().contains(bonus.getNumber())) {
            bonusResult.add(1);
            return;
        }
        bonusResult.add(0);
    }

    public List<Integer> getWinningResult() {
        return winningResult;
    }

    public List<Integer> getBonusResult() {
        return bonusResult;
    }
}
