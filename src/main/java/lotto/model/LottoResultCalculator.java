package lotto.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class LottoResultCalculator {

    private static final int ROUNDING_SCALE = 2;
    private static final int PERCENT_RATIO_UNIT = 100;

    private final WinningLotto winningLotto;

    public LottoResultCalculator(final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoResult getLottoResult(final LottoTickets lottoTickets, final PurchaseAmount purchaseAmount) {
        Map<LottoRank, Integer> ranks = calculateAllRanks(lottoTickets);
        BigInteger totalPrize = calculateWinningPrize(ranks);
        BigDecimal profitRate = calculateProfitRate(totalPrize, purchaseAmount);
        return new LottoResult(ranks, profitRate);
    }

    private BigInteger calculateWinningPrize(final Map<LottoRank, Integer> ranks) {
        return ranks.entrySet().stream()
                .map(rank -> rank.getKey().calculatePrizeByCount(rank.getValue()))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private Map<LottoRank, Integer> calculateAllRanks(final LottoTickets lottoTickets) {
        return lottoTickets.tickets().stream()
                .map(winningLotto::calculateRank)
                .collect(() -> new EnumMap<>(LottoRank.class),
                        (map, rank) -> map.merge(rank, 1, Integer::sum),
                        EnumMap::putAll);
    }

    private BigDecimal calculateProfitRate(final BigInteger totalPrize, final PurchaseAmount purchaseAmount) {
        BigDecimal amount = new BigDecimal(purchaseAmount.value());
        BigDecimal prize = new BigDecimal(totalPrize);
        return prize
                .divide(amount, ROUNDING_SCALE + 1, RoundingMode.HALF_EVEN)
                .multiply(new BigDecimal(String.valueOf(PERCENT_RATIO_UNIT)));
    }
}
