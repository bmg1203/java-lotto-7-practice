package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.constants.Rank;

public class LottoResult {

    private final Map<Rank, Long> result;

    public LottoResult(final List<Lotto> lottos, final WinningLotto winningLotto) {
        this.result = lottos.stream()
                .map(lotto -> Rank.valueOf(
                        winningLotto.matchCount(lotto), winningLotto.isBonusMatch(lotto))
                )
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public Long getCount(final Rank rank) {
        return result.getOrDefault(rank, 0L);
    }

    public Integer calculateTotalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue().intValue())
                .sum();
    }
}
