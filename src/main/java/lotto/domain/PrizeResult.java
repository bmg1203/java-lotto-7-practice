package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrizeResult {

    private static final int DEFAULT_VALUE = 0;
    private static final int COUNT = 1;

    private final Map<Prize, Integer> prizes;

    private PrizeResult(Map<Prize, Integer> prizes) {
        this.prizes = prizes;
    }

    public static PrizeResult create() {
        Map<Prize, Integer> winningPrizes = new LinkedHashMap<>();
        Arrays.stream(Prize.values()).forEach(
                prize -> winningPrizes.put(prize, DEFAULT_VALUE)
        );

        return new PrizeResult(winningPrizes);
    }

    public void increaseCountOf(Prize prize) {
        prizes.put(prize, prizes.get(prize) + COUNT);
    }

    public void removeNoPrize() {
        prizes.remove(Prize.NO_PRIZE);
    }
}
