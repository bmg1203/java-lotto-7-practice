package lotto.domain.winning;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.purchase.Money;

public class LottoProfit {

    private final Map<LottoRank, Integer> lottoRanks;
    private final Money money;

    public LottoProfit(final Map<LottoRank, Integer> lottoRanks, final Money money) {
        this.lottoRanks = lottoRanks;
        this.money = money;
    }

    public double getProfitRatio() {
        final BigDecimal totalPrice = getTotalPrice();
        return money.calculateRatio(totalPrice);
    }

    private BigDecimal getTotalPrice() {
        return lottoRanks.entrySet().stream()
                .map(this::calculateTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTotalPrice(final Entry<LottoRank, Integer> entry) {
        final int price = entry.getKey().getPrice().intValue();
        final Integer count = entry.getValue();
        return BigDecimal.valueOf((long) price * count);
    }
}
