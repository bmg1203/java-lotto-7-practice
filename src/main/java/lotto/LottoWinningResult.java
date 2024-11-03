package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoWinningResult {
    private final Map<WinningPrize, Integer> results;

    public LottoWinningResult() {
        results = new EnumMap<>(WinningPrize.class);
        Arrays.stream(WinningPrize.values()).forEach(winningPrize -> results.put(winningPrize, 0));
    }

    public void increment(WinningPrize prize) {
        results.put(prize, results.get(prize) + 1);
    }

    public Map<WinningPrize, Integer> getResults() {
        return results;
    }
}
