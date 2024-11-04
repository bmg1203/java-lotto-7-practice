package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.dto.WinningResultDto;

public class WinningService {

    public WinningResultDto calculateWinningResult(Lottos lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> rankCounts = calculateRankCounts(lottos, winningLotto);
        BigDecimal totalPrize = calculateTotalPrize(rankCounts);
        BigDecimal profitRate = calculateProfitRate(totalPrize, lottos.getLottoCount());

        return new WinningResultDto(rankCounts, profitRate);
    }

    private Map<Rank, Integer> calculateRankCounts(Lottos lottos, WinningLotto winningLotto) {
        return lottos.countMatchesWith(winningLotto);
    }

    private BigDecimal calculateTotalPrize(Map<Rank, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .map(entry -> calculatePrizeForRank(entry.getKey(), entry.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculatePrizeForRank(Rank rank, int count) {
        return BigDecimal.valueOf(rank.getPrize()).multiply(BigDecimal.valueOf(count));
    }

    private BigDecimal calculateProfitRate(BigDecimal totalPrize, int amount) {
        return totalPrize.divide(BigDecimal.valueOf(amount), 2, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(10), 2, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }

}

