package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.HashMap;

public class Ranking {

    public static void matchLotto(LottoTicket tickets, WinningLotto winningLotto) {
        HashMap<Rank, Integer> result = tickets.getResult();
        for (Lotto lotto : tickets.getLottoTickets()) {
            Rank rank = determineRank(winningLotto, lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    private static Rank determineRank(WinningLotto winningLotto, Lotto lotto) {
        int count = countCorrect(winningLotto, lotto);
        boolean isMatchBonus = isContainsBonus(winningLotto, lotto);
        return Rank.assign(count, isMatchBonus);
    }

    private static int countCorrect(WinningLotto winningLotto, Lotto lotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isContainsBonus(WinningLotto winningLotto, Lotto lotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }
}
