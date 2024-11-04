package lotto.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class LottoRepository {

    private static final Set<List<Integer>> lottoTickets = new HashSet<>();
    private static Lotto winningLotto = null;

    public void insertNumbers(List<Integer> randomNumbers) {
        lottoTickets.add(randomNumbers);
    }

    public Set<List<Integer>> getLottoTickets() {
        return lottoTickets;
    }

    public void insertWinningLotto(Lotto lotto) {
        winningLotto = lotto;
    }

}
