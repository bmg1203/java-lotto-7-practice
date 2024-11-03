package lotto.vendingmachine;

import lotto.draw.Rank;

import java.util.List;
import java.util.Map;

public interface VendingMachineRepository {

    void save(List<Lotto> lottos);

    void saveWinningStatistics(Map<Rank, Integer> statistics);

    List<Lotto> getStoredLottoTickets();

    Map<Rank, Integer> getWinningStatistics();
}
