package lotto.dto;

import java.util.List;
import java.util.Objects;
import lotto.domain.Lotto;
import lotto.domain.Won;

public class LottoPaper {

    private final Won purchasePrice;
    private final List<Lotto> lottos;

    public LottoPaper(Won purchasePrice, List<Lotto> lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPaper that = (LottoPaper) o;
        return Objects.equals(purchasePrice, that.purchasePrice) && Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasePrice, lottos);
    }
}
